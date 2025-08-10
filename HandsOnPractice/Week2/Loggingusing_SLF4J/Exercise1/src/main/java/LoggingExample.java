package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Step 1: Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Step 2: Log messages
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
