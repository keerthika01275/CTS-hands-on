package com.adapter;

// Third-party PayPal payment gateway
public class PayPalGateway {
    public int makePayment(float amountInDollars) {
        System.out.println("Processing $" + amountInDollars + " payment via PayPal");
        // Simulate payment processing
        return (int)(Math.random() * 1000000); // Return transaction ID
    }

    public boolean refund(int transactionId) {
        System.out.println("Refunding PayPal transaction: " + transactionId);
        return true;
    }

    public String getTransactionDetails(int transactionId) {
        return "PayPal Transaction " + transactionId + " is completed";
    }
}
