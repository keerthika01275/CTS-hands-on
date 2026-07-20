package com.observer;

public class StockUpdate {
    private String symbol;
    private double price;
    private double change;

    public StockUpdate(String symbol, double price, double change) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f (%.2f%%)", symbol, price, change);
    }
}
