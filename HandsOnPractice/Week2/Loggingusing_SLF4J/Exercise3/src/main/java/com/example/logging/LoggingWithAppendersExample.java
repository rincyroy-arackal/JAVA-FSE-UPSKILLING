package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithAppendersExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingWithAppendersExample.class);

    public static void main(String[] args) {
        logger.info("This is an INFO level message.");
        logger.warn("This is a WARNING level message.");
        logger.error("This is an ERROR level message.");
        logger.debug("This is a DEBUG level message.");
    }
}
