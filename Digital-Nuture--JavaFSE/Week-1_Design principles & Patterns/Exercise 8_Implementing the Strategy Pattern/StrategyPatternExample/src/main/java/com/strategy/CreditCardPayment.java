package com.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String cardNumber, String name, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card");
        System.out.println("Card Number: " + maskCardNumber());
        System.out.println("Name: " + name);
        // In real implementation, this would process the payment through a payment gateway
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    private String maskCardNumber() {
        return "xxxx-xxxx-xxxx-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
