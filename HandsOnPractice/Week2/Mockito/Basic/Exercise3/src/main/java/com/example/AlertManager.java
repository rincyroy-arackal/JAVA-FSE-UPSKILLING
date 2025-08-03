package com.example;

public class AlertManager {
    private final NotificationService notificationService;

    public AlertManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void alert(String user) {
        notificationService.send(user, "This is a critical alert!");
    }
}
