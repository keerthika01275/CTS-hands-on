package com.strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private double amount;

    public PaymentContext(double amount) {
        this.amount = amount;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean processPayment() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        System.out.println("\nProcessing payment of $" + amount);
        return paymentStrategy.pay(amount);
    }

    public String getSelectedPaymentMethod() {
        if (paymentStrategy == null) {
            return "No payment method selected";
        }
        return paymentStrategy.getPaymentMethod();
    }
}
