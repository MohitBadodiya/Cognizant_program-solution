import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private com.myorg.dn4.Calculator calculator;

    @Before
    public void initialize() {
        // This runs before each test method
        calculator = new com.myorg.dn4.Calculator();
    }

    @Test
    public void testAddition() {
        assertEquals("Addition failed", 5, calculator.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals("Subtraction failed", 4, calculator.subtract(7, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals("Multiplication failed", 12, calculator.multiply(4, 3));
    }

    @Test
    public void testDivision() {
        assertEquals("Division failed", 2.5, calculator.divide(5, 2), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivision
