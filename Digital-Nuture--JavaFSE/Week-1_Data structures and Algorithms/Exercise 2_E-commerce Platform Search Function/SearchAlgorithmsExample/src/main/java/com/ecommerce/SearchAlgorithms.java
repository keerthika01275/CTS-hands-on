package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class SearchAlgorithms {
    
    /**
     * Linear Search by Product ID
     * Time Complexity: O(n) - where n is the number of products
     * Best Case: O(1) - when the item is at the first position
     * Average Case: O(n/2)
     * Worst Case: O(n) - when the item is at the last position or not found
     */
    public static Product linearSearchById(List<Product> products, int targetId) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        for (Product product : products) {
            comparisons++;
            if (product.getProductId() == targetId) {
                long endTime = System.nanoTime();
                System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return product;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Linear Search by Product Name (partial match)
     * Time Complexity: O(n) - must check all products
     */
    public static List<Product> linearSearchByName(List<Product> products, String targetName) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        List<Product> results = new ArrayList<>();
        String searchName = targetName.toLowerCase();

        for (Product product : products) {
            comparisons++;
            if (product.getProductName().toLowerCase().contains(searchName)) {
                results.add(product);
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Linear Search by Name took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return results;
    }

    /**
     * Binary Search by Product ID (requires sorted array)
     * Time Complexity: O(log n) - where n is the number of products
     * Best Case: O(1) - when the middle element is the target
     * Average and Worst Case: O(log n)
     */
    public static Product binarySearchById(List<Product> products, int targetId) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            Product midProduct = products.get(mid);

            if (midProduct.getProductId() == targetId) {
                long endTime = System.nanoTime();
                System.out.printf("Binary Search took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return midProduct;
            }

            if (midProduct.getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Binary Search took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Linear Search by Category
     * Time Complexity: O(n) - must check all products
     */
    public static List<Product> searchByCategory(List<Product> products, String category) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        List<Product> results = new ArrayList<>();
        String searchCategory = category.toLowerCase();

        for (Product product : products) {
            comparisons++;
            if (product.getCategory().toLowerCase().equals(searchCategory)) {
                results.add(product);
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Category Search took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return results;
    }
}
