package com.ecommerce;

import java.util.List;

public class SortingAlgorithms {

    /**
     * Bubble Sort Implementation
     * Time Complexity: O(n²) for all cases
     * Space Complexity: O(1)
     */
    public static void bubbleSort(List<Order> orders) {
        long startTime = System.nanoTime();
        int n = orders.size();
        int swaps = 0;
        int comparisons = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (orders.get(j).compareTo(orders.get(j + 1)) > 0) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            // If no swapping occurred, array is already sorted
            if (!swapped) break;
        }

        long endTime = System.nanoTime();
        System.out.printf("Bubble Sort completed in %d ns with %d comparisons and %d swaps%n", 
            (endTime - startTime), comparisons, swaps);
    }

    /**
     * Quick Sort Implementation
     * Time Complexity: 
     * - Average Case: O(n log n)
     * - Worst Case: O(n²) [rare with good pivot selection]
     * Space Complexity: O(log n)
     */
    public static void quickSort(List<Order> orders) {
        long startTime = System.nanoTime();
        QuickSortStats stats = new QuickSortStats();
        quickSort(orders, 0, orders.size() - 1, stats);
        long endTime = System.nanoTime();
        System.out.printf("Quick Sort completed in %d ns with %d comparisons and %d swaps%n", 
            (endTime - startTime), stats.comparisons, stats.swaps);
    }

    private static void quickSort(List<Order> orders, int low, int high, QuickSortStats stats) {
        if (low < high) {
            int pi = partition(orders, low, high, stats);
            quickSort(orders, low, pi - 1, stats);
            quickSort(orders, pi + 1, high, stats);
        }
    }

    private static int partition(List<Order> orders, int low, int high, QuickSortStats stats) {
        // Using the last element as pivot
        Order pivot = orders.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            stats.comparisons++;
            if (orders.get(j).compareTo(pivot) <= 0) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
                stats.swaps++;
            }
        }

        // Swap orders[i+1] and orders[high] (pivot)
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);
        stats.swaps++;

        return i + 1;
    }

    private static class QuickSortStats {
        int comparisons = 0;
        int swaps = 0;
    }
}
