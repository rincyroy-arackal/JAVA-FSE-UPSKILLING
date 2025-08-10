package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "rincy";
        int age = 25;
        String country = "India";

        // ✅ Parameterized logging
        logger.info("User {} is {} years old and lives in {}", username, age, country);

        // ✅ Also works with other levels
        logger.warn("Low disk space on user {}'s device", username);
        logger.error("Failed to process request for user {} at age {}", username, age);
    }
}
