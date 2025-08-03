package com.example;

public class MultiService {
    private final ExternalApi api;

    public MultiService(ExternalApi api) {
        this.api = api;
    }

    public String checkTwice() {
        String first = api.getStatus();
        String second = api.getStatus();
        return first + " then " + second;
    }
}
