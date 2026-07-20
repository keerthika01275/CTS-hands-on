package com.observer;

public class ObserverTest {
    public static void main(String[] args) {
        // Create the stock market
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp1 = new MobileApp("John's iPhone");
        Observer mobileApp2 = new MobileApp("Jane's Android");
        Observer webApp1 = new WebApp("Trading Platform");

        System.out.println("Registering observers...\n");

        // Register observers
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        System.out.println("\nUpdating stock prices...\n");

        // Simulate some stock price updates
        stockMarket.updateStockPrice("AAPL", 150.50, 2.5);
        System.out.println();
        
        stockMarket.updateStockPrice("GOOGL", 2750.00, 1.8);
        System.out.println();

        System.out.println("Removing one observer...\n");
        // Remove one observer
        stockMarket.removeObserver(mobileApp2);

        System.out.println("Updating stock price after removing observer...\n");
        // Update price again
        stockMarket.updateStockPrice("MSFT", 290.75, -0.5);
    }
}
