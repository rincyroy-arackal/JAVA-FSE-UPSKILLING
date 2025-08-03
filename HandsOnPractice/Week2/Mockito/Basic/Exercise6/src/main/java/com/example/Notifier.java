package com.example;

public interface Notifier {
    void connect();
    void sendAlert(String message);
    void disconnect();
}
