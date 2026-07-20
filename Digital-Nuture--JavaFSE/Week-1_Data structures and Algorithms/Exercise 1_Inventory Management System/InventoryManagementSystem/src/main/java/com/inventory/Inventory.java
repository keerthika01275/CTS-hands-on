package com.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    /**
     * Add a new product to the inventory
     * Time Complexity: O(1)
     */
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Product added successfully: " + product);
    }

    /**
     * Update an existing product in the inventory
     * Time Complexity: O(1)
     */
    public void updateProduct(String productId, String name, int quantity, double price) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }
        product.setProductName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        System.out.println("Product updated successfully: " + product);
    }

    /**
     * Delete a product from the inventory
     * Time Complexity: O(1)
     */
    public void deleteProduct(String productId) {
        Product removedProduct = products.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product deleted successfully: " + removedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    /**
     * Get a product by its ID
     * Time Complexity: O(1)
     */
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    /**
     * List all products in the inventory
     * Time Complexity: O(n)
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * Search products by name (case-insensitive partial match)
     * Time Complexity: O(n)
     */
    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        String searchName = name.toLowerCase();
        
        for (Product product : products.values()) {
            if (product.getProductName().toLowerCase().contains(searchName)) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Get total inventory value
     * Time Complexity: O(n)
     */
    public double getTotalInventoryValue() {
        return products.values().stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    /**
     * Check if a product is low in stock (quantity < threshold)
     * Time Complexity: O(1)
     */
    public boolean isLowStock(String productId, int threshold) {
        Product product = products.get(productId);
        return product != null && product.getQuantity() < threshold;
    }

    /**
     * Get all products that are low in stock
     * Time Complexity: O(n)
     */
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getQuantity() < threshold) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }
}
