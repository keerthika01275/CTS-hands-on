package com.ecommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SearchDemo {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = generateProducts(1000);  // Generate 1000 products
        
        System.out.println("E-commerce Platform Search Algorithms Demo");
        System.out.println("=========================================");

        // 1. Linear Search by ID
        System.out.println("\n1. Linear Search by ID (searching for ID 500):");
        Product foundProduct = SearchAlgorithms.linearSearchById(products, 500);
        if (foundProduct != null) {
            System.out.println("Found: " + foundProduct);
        }

        // 2. Binary Search by ID (requires sorted list)
        System.out.println("\n2. Binary Search by ID (searching for ID 500):");
        // Sort products by ID first (required for binary search)
        Collections.sort(products);
        foundProduct = SearchAlgorithms.binarySearchById(products, 500);
        if (foundProduct != null) {
            System.out.println("Found: " + foundProduct);
        }

        // 3. Search by Name (partial match)
        System.out.println("\n3. Search by Product Name (containing 'phone'):");
        List<Product> foundProducts = SearchAlgorithms.linearSearchByName(products, "phone");
        System.out.println("Found " + foundProducts.size() + " products:");
        foundProducts.forEach(System.out::println);

        // 4. Search by Category
        System.out.println("\n4. Search by Category ('electronics'):");
        foundProducts = SearchAlgorithms.searchByCategory(products, "electronics");
        System.out.println("Found " + foundProducts.size() + " products in category:");
        foundProducts.forEach(System.out::println);

        // 5. Performance Comparison for ID search
        System.out.println("\n5. Performance Comparison (searching for ID 999):");
        // Linear Search
        System.out.println("\nLinear Search:");
        SearchAlgorithms.linearSearchById(products, 999);
        
        // Binary Search
        System.out.println("\nBinary Search:");
        SearchAlgorithms.binarySearchById(products, 999);
    }

    private static List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        String[] categories = {"electronics", "clothing", "books", "toys", "food"};
        String[] productTypes = {"phone", "laptop", "shirt", "book", "game"};
        
        for (int i = 0; i < count; i++) {
            String category = categories[random.nextInt(categories.length)];
            String type = productTypes[random.nextInt(productTypes.length)];
            String name = type + " " + (i + 1);
            double price = 10.0 + random.nextDouble() * 990.0; // Random price between 10 and 1000
            
            products.add(new Product(i, name, category, price));
        }
        
        return products;
    }
}
