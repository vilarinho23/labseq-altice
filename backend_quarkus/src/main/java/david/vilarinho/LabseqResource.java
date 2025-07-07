package david.vilarinho;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.Map;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Labseq API", description = "Returns values from the labseq sequence")
public class LabseqResource {

    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    @Operation(summary = "Get Labseq value", description = "Returns the Labseq sequence value at the given index n")
    @APIResponse(responseCode = "200", description = "Labseq value retrieved successfully")
    @APIResponse(responseCode = "400", description = "Invalid index (must be non-negative)")
    public Response getLabseqValue(
            @Parameter(description = "Index n (must be ≥ 0)", required = true)
            @PathParam("n") int n) {

        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error", "Index must be non-negative"))
                    .build();
        }

        return Response.ok(Map.of(
                "n", n,
                "value", service.calculate(n)
        )).build();
    }
}
