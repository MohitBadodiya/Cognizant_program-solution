package com.example;

import org.junit.Test;
import static org.junit.Assert.*;  // Importing all JUnit assertion methods

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert that two values are equal
        assertEquals("Checking if 2+3 equals 5", 5, 2 + 3);

        // Assert that a condition is true
        assertTrue("5 should be greater than 3", 5 > 3);

        // Assert that a condition is false
        assertFalse("5 should not be less than 3", 5 < 3);

        // Assert that an object is null
        assertNull("This should be null", null);

        // Assert that an object is not null
        assertNotNull("This should not be null", new Object());
    }
}
