package com.myorg.dn4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAAExampleTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // ARRANGE: Initialize Calculator instance
        calculator = new Calculator();
    }

    @After
    public void cleanUp() {
        // TEARDOWN: Clear reference
        calculator = null;
    }

    @Test
    public void testAddUsingAAA() {
        // ACT: Perform addition
        int actualResult = calculator.add(10, 20);

        // ASSERT: Verify result
        assertEquals(30, actualResult);
    }
}
