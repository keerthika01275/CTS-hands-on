package com.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private static final Map<String, RealImage> imageCache = new HashMap<>();
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Check cache first
        if (imageCache.containsKey(filename)) {
            System.out.println("Retrieving from cache: " + filename);
            realImage = imageCache.get(filename);
        } else {
            // If not in cache, create new RealImage and cache it
            System.out.println("Image not in cache. Creating new instance.");
            realImage = new RealImage(filename);
            imageCache.put(filename, realImage);
        }
        
        // Display the image
        realImage.display();
    }

    @Override
    public String getFilename() {
        return filename;
    }

    // Method to check if an image is cached
    public static boolean isImageCached(String filename) {
        return imageCache.containsKey(filename);
    }

    // Method to clear the cache
    public static void clearCache() {
        imageCache.clear();
        System.out.println("Cache cleared");
    }
}
