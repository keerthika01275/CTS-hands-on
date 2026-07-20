package com.singleton;

public class Logger {
    // Private static instance of the class
    private static Logger instance;
    
    // Private constructor to prevent instantiation
    private Logger() {
        // Private constructor to prevent instantiation from other classes
    }
    
    // Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    // Method to log messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
