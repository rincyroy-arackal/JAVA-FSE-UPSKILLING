package com.example;

public class Processor {
    private final Logger logger;

    public Processor(Logger logger) {
        this.logger = logger;
    }

    public void process() {
        // does some processing and logs it
        logger.log("Processing complete");
    }
}
