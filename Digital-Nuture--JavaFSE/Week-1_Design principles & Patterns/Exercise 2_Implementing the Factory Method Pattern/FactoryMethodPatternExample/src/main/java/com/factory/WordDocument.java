package com.factory;

public class WordDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating Word document...");
    }

    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }
}
