package com.myorg.dn4;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class ParamLoggingTest {

    private ListAppender<ILoggingEvent> logAppender;

    @Before
    public void setUpLogAppender() {
        // Get Logback logger for ParamLogging class
        Logger logger = (Logger) LoggerFactory.getLogger(com.myorg.dn4.ParamLogging.class);

        // Attach ListAppender to capture logs
        logAppender = new ListAppender<>();
        logAppender.start();
        logger.addAppender(logAppender);
    }

    @Test
    public void testInfoLogWithParameters() {
        // Run main method to generate log
        com.myorg.dn4.ParamLogging.main(new String[]{});

        // Retrieve captured logs
        List<ILoggingEvent> capturedLogs = logAppender.list;

        // Ensure logs are not empty
        assertFalse("Expected logs but found none.", capturedLogs.isEmpty());

        // Validate first log entry
        ILoggingEvent firstLog = capturedLogs.get(0);
        assertEquals("INFO", firstLog.getLevel().toString());
        assertEquals("User alice has 5 items in their cart.", firstLog.getFormattedMessage());
    }
}
