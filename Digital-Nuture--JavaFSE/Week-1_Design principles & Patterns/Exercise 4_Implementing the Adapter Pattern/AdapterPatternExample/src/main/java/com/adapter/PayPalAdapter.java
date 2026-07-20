package com.adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;
    private int lastTransactionId;

    public PayPalAdapter() {
        this.paypalGateway = new PayPalGateway();
    }

    @Override
    public boolean processPayment(double amount) {
        lastTransactionId = paypalGateway.makePayment((float)amount);
        return lastTransactionId > 0;
    }

    @Override
    public void refundPayment(String transactionId) {
        int paypalTransactionId = Integer.parseInt(transactionId);
        paypalGateway.refund(paypalTransactionId);
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        int paypalTransactionId = Integer.parseInt(transactionId);
        return paypalGateway.getTransactionDetails(paypalTransactionId);
    }

    public String getLastTransactionId() {
        return String.valueOf(lastTransactionId);
    }
}
