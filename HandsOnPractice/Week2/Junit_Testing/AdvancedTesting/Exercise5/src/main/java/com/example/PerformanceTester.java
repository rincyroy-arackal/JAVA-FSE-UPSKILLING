package com.example;

public class PerformanceTester {

    public void performTask() {
        // Simulate a task that should complete quickly
        try {
            Thread.sleep(300); // 300ms delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
