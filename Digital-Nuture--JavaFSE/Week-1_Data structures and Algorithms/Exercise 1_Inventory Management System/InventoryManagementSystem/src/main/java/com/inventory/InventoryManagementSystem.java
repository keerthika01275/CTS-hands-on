package com.inventory;

import java.util.List;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Create a new inventory
        Inventory inventory = new Inventory();

        System.out.println("Inventory Management System Demo");
        System.out.println("================================");

        // Add products
        System.out.println("\n1. Adding Products:");
        inventory.addProduct(new Product("P1", "Laptop", 10, 999.99));
        inventory.addProduct(new Product("P2", "Smartphone", 20, 599.99));
        inventory.addProduct(new Product("P3", "Tablet", 15, 299.99));
        // Try adding duplicate product
        inventory.addProduct(new Product("P1", "Desktop", 5, 1299.99));

        // Update product
        System.out.println("\n2. Updating Products:");
        inventory.updateProduct("P2", "Smartphone Pro", 25, 699.99);
        // Try updating non-existent product
        inventory.updateProduct("P4", "Monitor", 10, 199.99);

        // Search products
        System.out.println("\n3. Searching Products by Name (contains 'phone'):");
        List<Product> searchResults = inventory.searchProductsByName("phone");
        searchResults.forEach(System.out::println);

        // Check low stock
        System.out.println("\n4. Checking Low Stock Products (threshold: 12):");
        List<Product> lowStock = inventory.getLowStockProducts(12);
        lowStock.forEach(System.out::println);

        // Calculate total inventory value
        System.out.println("\n5. Total Inventory Value:");
        System.out.printf("Total Value: $%.2f%n", inventory.getTotalInventoryValue());

        // Delete product
        System.out.println("\n6. Deleting Products:");
        inventory.deleteProduct("P3");
        // Try deleting non-existent product
        inventory.deleteProduct("P4");

        // List all remaining products
        System.out.println("\n7. Current Inventory:");
        List<Product> allProducts = inventory.getAllProducts();
        allProducts.forEach(System.out::println);
    }
}
