public class AdapterPatternTest {
    public static void main(String[] args) {
        // Using PayPal
        PayPalGateway paypalGateway = new PayPalGateway();
        PaymentProcessor paypalProcessor = new PayPalAdapter(paypalGateway);
        paypalProcessor.processPayment(1500);

        // Using Stripe
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(2200);
    }
}
