package com.example.strategy;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Alice"));
        context.processPayment(500.0);

        System.out.println("----");

        // Paying with PayPal
        context.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        context.processPayment(300.0);
    }
}
