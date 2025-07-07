package david.vilarinho;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabseqServiceTest {

    LabseqService service = new LabseqService();

    @Test
    void testBaseCases() {
        assertEquals("0", service.calculate(0));
        assertEquals("1", service.calculate(1));
        assertEquals("0", service.calculate(2));
        assertEquals("1", service.calculate(3));
    }

    @Test
    void testRecursiveValues() {
        assertEquals("1", service.calculate(4)); // l(0) + l(1)
        assertEquals("1", service.calculate(5)); // l(1) + l(2)
        assertEquals("1", service.calculate(6)); // l(2) + l(3)
        assertEquals("2", service.calculate(7)); // l(3) + l(4)
        assertEquals("2", service.calculate(8)); // l(4) + l(5)
    }

    @Test
    void testLargeValue() {
        String result = service.calculate(100_000);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testNegativeInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate(-1));
    }
}

