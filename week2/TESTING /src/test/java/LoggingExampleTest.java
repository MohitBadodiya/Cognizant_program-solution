package com.myorg.dn4;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class LoggingExampleTest {

    private ListAppender<ILoggingEvent> logAppender;

    @Before
    public void setUpAppender() {
        // Get Logback logger for LoggingExample
        Logger logger = (Logger) LoggerFactory.getLogger(com.myorg.dn4.LoggingExample.class);

        // Set up ListAppender to capture logs
        logAppender = new ListAppender<>();
        logAppender.start();
        logger.addAppender(logAppender);
    }

    @Test
    public void testErrorAndWarningLogs() {
        // Run the main method to generate logs
        com.myorg.dn4.LoggingExample.main(new String[]{});

        // Fetch captured logs
        List<ILoggingEvent> capturedLogs = logAppender.list;

        // Ensure at least 2 logs were captured
        assertTrue("Expected at least 2 log messages", capturedLogs.size() >= 2);

        // Assert error message and its level
        assertEquals("This is an error message", capturedLogs.get(0).getFormattedMessage());
        assertEquals("ERROR", capturedLogs.get(0).getLevel().toString());

        // Assert warning message and its level
        assertEquals("This is a warning message", capturedLogs.get(1).getFormattedMessage());
        assertEquals("WARN", capturedLogs.get(1).getLevel().toString());
    }
}
