package com.ecommerce;

public class Order implements Comparable<Order> {
    private String orderId;
    private String customerName;
    private double totalPrice;
    private int itemCount;
    private String orderDate;

    public Order(String orderId, String customerName, double totalPrice, int itemCount, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.itemCount = itemCount;
        this.orderDate = orderDate;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return String.format("Order{id='%s', customer='%s', price=%.2f, items=%d, date='%s'}", 
            orderId, customerName, totalPrice, itemCount, orderDate);
    }

    @Override
    public int compareTo(Order other) {
        return Double.compare(this.totalPrice, other.totalPrice);
    }
}
