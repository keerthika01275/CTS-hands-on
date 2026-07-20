package com.proxy;

public class RealImage implements Image {
    private String filename;
    private byte[] imageData;

    public RealImage(String filename) {
        this.filename = filename;
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + filename);
        // Simulate loading image from server with some delay
        try {
            Thread.sleep(1000); // Simulate network delay
            this.imageData = new byte[1024]; // Simulate image data
            System.out.println("Image loaded successfully: " + filename);
        } catch (InterruptedException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        if (imageData == null) {
            loadImageFromServer();
        }
        System.out.println("Displaying image: " + filename);
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
