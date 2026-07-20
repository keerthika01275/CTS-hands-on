package com.factory;

public class PdfDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating PDF document...");
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }
}
