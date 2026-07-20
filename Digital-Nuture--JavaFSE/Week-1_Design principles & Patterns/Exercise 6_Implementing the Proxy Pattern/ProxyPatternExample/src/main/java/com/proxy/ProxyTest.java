package com.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // Create proxy for first image
        System.out.println("1. First time loading image1.jpg:");
        Image image1 = new ProxyImage("image1.jpg");
        image1.display();
        System.out.println();

        // Load the same image again (should use cache)
        System.out.println("2. Loading image1.jpg again:");
        Image image1Again = new ProxyImage("image1.jpg");
        image1Again.display();
        System.out.println();

        // Load a different image
        System.out.println("3. Loading image2.jpg:");
        Image image2 = new ProxyImage("image2.jpg");
        image2.display();
        System.out.println();

        // Clear the cache
        System.out.println("4. Clearing the cache...");
        ProxyImage.clearCache();
        System.out.println();

        // Load image1 again after cache clear
        System.out.println("5. Loading image1.jpg after cache clear:");
        Image image1AfterClear = new ProxyImage("image1.jpg");
        image1AfterClear.display();
    }
}
