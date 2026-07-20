package com.strategy;

public class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal");
        System.out.println("Email: " + emailId);
        // In real implementation, this would process the payment through PayPal API
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
