import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testBasicAssertions() {
        // Check equality
        assertEquals("2 + 3 should equal 5", 5, 2 + 3);

        // Check true condition
        assertTrue("5 is greater than 3", 5 > 3);

        // Check false condition
        assertFalse("5 is not less than 3", 5 < 3);

        // Check for null
        Object nullObject = null;
        assertNull("Object should be null", nullObject);

        // Check for non-null
        Object nonNullObject = new Object();
        assertNotNull("Object should not be null", nonNullObject);
    }
}
