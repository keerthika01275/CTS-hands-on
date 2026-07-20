package com.adapter;

public interface PaymentProcessor {
    boolean processPayment(double amount);
    void refundPayment(String transactionId);
    String getPaymentStatus(String transactionId);
}
