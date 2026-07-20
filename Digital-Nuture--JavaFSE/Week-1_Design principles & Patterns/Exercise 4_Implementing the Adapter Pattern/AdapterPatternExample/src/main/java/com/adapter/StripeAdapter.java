package com.adapter;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    private String lastTransactionId;

    public StripeAdapter() {
        this.stripeGateway = new StripeGateway();
    }

    @Override
    public boolean processPayment(double amount) {
        lastTransactionId = stripeGateway.executePayment(amount);
        return lastTransactionId != null && !lastTransactionId.isEmpty();
    }

    @Override
    public void refundPayment(String transactionId) {
        stripeGateway.reversePayment(transactionId);
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        return stripeGateway.checkStatus(transactionId);
    }

    public String getLastTransactionId() {
        return lastTransactionId;
    }
}
