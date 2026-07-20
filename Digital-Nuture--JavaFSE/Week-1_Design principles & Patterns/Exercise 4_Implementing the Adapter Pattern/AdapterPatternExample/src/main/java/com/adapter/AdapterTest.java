package com.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        // Test PayPal Payment
        System.out.println("Testing PayPal Payment:");
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        testPaymentProcessor(paypalProcessor, 99.99);
        
        System.out.println("\n------------------------\n");

        // Test Stripe Payment
        System.out.println("Testing Stripe Payment:");
        PaymentProcessor stripeProcessor = new StripeAdapter();
        testPaymentProcessor(stripeProcessor, 149.99);
    }

    private static void testPaymentProcessor(PaymentProcessor processor, double amount) {
        // Process Payment
        boolean paymentResult = processor.processPayment(amount);
        System.out.println("Payment processed successfully: " + paymentResult);

        // Get transaction ID (we'll use the last transaction from the adapters)
        String transactionId = "";
        if (processor instanceof PayPalAdapter) {
            transactionId = ((PayPalAdapter) processor).getLastTransactionId();
        } else if (processor instanceof StripeAdapter) {
            transactionId = ((StripeAdapter) processor).getLastTransactionId();
        }

        // Check Status
        String status = processor.getPaymentStatus(transactionId);
        System.out.println("Payment Status: " + status);

        // Process Refund
        System.out.println("Processing refund...");
        processor.refundPayment(transactionId);
    }
}
