package com.example.decorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS and Slack notifications
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier multiNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification through all channels
        multiNotifier.send("Server is down!");
    }
}
