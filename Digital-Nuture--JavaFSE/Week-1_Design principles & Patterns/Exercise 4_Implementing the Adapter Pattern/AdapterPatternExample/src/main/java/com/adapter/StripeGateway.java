package com.adapter;

// Third-party Stripe payment gateway
public class StripeGateway {
    public String executePayment(double amountInUSD) {
        System.out.println("Processing $" + amountInUSD + " payment via Stripe");
        // Simulate payment processing
        return "STRIPE_" + (int)(Math.random() * 1000000); // Return transaction ID
    }

    public void reversePayment(String stripeTransactionId) {
        System.out.println("Refunding Stripe transaction: " + stripeTransactionId);
    }

    public String checkStatus(String stripeTransactionId) {
        return "Stripe Transaction " + stripeTransactionId + " is successful";
    }
}
