package com.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private List<StockUpdate> stockUpdates;

    public StockMarket() {
        observers = new ArrayList<>();
        stockUpdates = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("New observer registered");
            // Send latest updates to new observer
            for (StockUpdate update : stockUpdates) {
                observer.update(update);
            }
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer unregistered");
        }
    }

    @Override
    public void notifyObservers(StockUpdate update) {
        stockUpdates.add(update);
        for (Observer observer : observers) {
            observer.update(update);
        }
    }

    public void updateStockPrice(String symbol, double price, double change) {
        StockUpdate update = new StockUpdate(symbol, price, change);
        notifyObservers(update);
    }
}
