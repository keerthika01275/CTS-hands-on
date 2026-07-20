package com.observer;

public class MobileApp implements Observer {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(StockUpdate stockUpdate) {
        System.out.println("Mobile App - " + userName + " received update: " + stockUpdate);
    }
}
