package com.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        // Create a payment context with amount
        PaymentContext context = new PaymentContext(100.50);
        
        System.out.println("1. Testing Credit Card Payment:");
        // Create credit card payment strategy
        PaymentStrategy creditCard = new CreditCardPayment(
            "1234567890123456",
            "John Doe",
            "123",
            "12/25"
        );
        
        // Set and process credit card payment
        context.setPaymentStrategy(creditCard);
        System.out.println("Selected payment method: " + context.getSelectedPaymentMethod());
        context.processPayment();

        System.out.println("\n2. Testing PayPal Payment:");
        // Create PayPal payment strategy
        PaymentStrategy payPal = new PayPalPayment(
            "john.doe@example.com",
            "secretpassword"
        );
        
        // Set and process PayPal payment
        context.setPaymentStrategy(payPal);
        System.out.println("Selected payment method: " + context.getSelectedPaymentMethod());
        context.processPayment();

        // Demonstrate changing strategy at runtime
        System.out.println("\n3. Testing payment with no strategy:");
        context.setPaymentStrategy(null);
        System.out.println("Selected payment method: " + context.getSelectedPaymentMethod());
        
        try {
            context.processPayment();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
