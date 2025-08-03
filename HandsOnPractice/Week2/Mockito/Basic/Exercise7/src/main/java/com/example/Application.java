package com.example;

public class Application {
    private final Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void run() {
        logger.log("App is running...");
    }
}
