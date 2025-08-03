package com.example;

public class AlertSystem {
    private final Notifier notifier;

    public AlertSystem(Notifier notifier) {
        this.notifier = notifier;
    }

    public void triggerAlert() {
        notifier.connect();
        notifier.sendAlert("Intrusion detected!");
        notifier.disconnect();
    }
}
