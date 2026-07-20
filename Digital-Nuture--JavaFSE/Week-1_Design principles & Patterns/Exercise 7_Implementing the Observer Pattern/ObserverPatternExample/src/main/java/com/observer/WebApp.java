package com.observer;

public class WebApp implements Observer {
    private String userName;

    public WebApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(StockUpdate stockUpdate) {
        System.out.println("Web App - " + userName + " received update: " + stockUpdate);
    }
}
