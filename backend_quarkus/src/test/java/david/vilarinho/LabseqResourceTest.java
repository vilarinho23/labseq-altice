package david.vilarinho;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class LabseqResourceTest {

    @Test
    void testGetLabseqValue() {
        given()
                .when().get("/labseq/7")
                .then()
                .statusCode(200)
                .body("n", equalTo(7))
                .body("value", equalTo("2"));
    }

    @Test
    void testNegativeInputReturnsBadRequest() {
        given()
                .when().get("/labseq/-1")
                .then()
                .statusCode(400)
                .body("error", containsString("non-negative"));
    }

    @Test
    void testLargeInputReturnsValue() {
        given()
                .when().get("/labseq/100000")
                .then()
                .statusCode(200)
                .body("n", equalTo(100000))
                .body("value", not(isEmptyOrNullString()));
    }
}

