package com.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        // Get Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Log some messages using both instances
        logger1.log("This is a log message from logger1");
        logger2.log("This is a log message from logger2");
        
        // Check if both instances are the same
        System.out.println("\nChecking if logger1 and logger2 are the same instance:");
        System.out.println("logger1 hash code: " + logger1.hashCode());
        System.out.println("logger2 hash code: " + logger2.hashCode());
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        
        // Demonstrate thread-safety
        System.out.println("\nTesting thread safety with multiple threads:");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                Logger logger = Logger.getInstance();
                logger.log("Logging from thread: " + Thread.currentThread().getName());
            });
            thread.start();
        }
    }
}
