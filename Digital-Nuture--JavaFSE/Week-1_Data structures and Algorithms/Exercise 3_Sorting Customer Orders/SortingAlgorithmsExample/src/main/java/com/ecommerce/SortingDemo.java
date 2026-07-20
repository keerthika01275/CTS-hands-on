package com.ecommerce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingDemo {
    public static void main(String[] args) {
        // Test with different dataset sizes
        int[] dataSizes = {10, 100, 1000, 10000};

        for (int size : dataSizes) {
            System.out.println("\nTesting with " + size + " orders:");
            System.out.println("================================");

            // Generate test data
            List<Order> ordersBubble = generateOrders(size);
            List<Order> ordersQuick = new ArrayList<>(ordersBubble); // Create a copy for fair comparison

            // Display first few orders before sorting
            System.out.println("\nFirst 5 orders before sorting:");
            displayFirstNOrders(ordersBubble, 5);

            // Sort using Bubble Sort
            System.out.println("\nBubble Sort Performance:");
            SortingAlgorithms.bubbleSort(ordersBubble);

            // Sort using Quick Sort
            System.out.println("\nQuick Sort Performance:");
            SortingAlgorithms.quickSort(ordersQuick);

            // Verify sorting results
            System.out.println("\nFirst 5 orders after sorting (Bubble Sort):");
            displayFirstNOrders(ordersBubble, 5);

            // Verify both algorithms produced the same results
            boolean sortedCorrectly = validateSorting(ordersBubble, ordersQuick);
            System.out.println("\nBoth sorting algorithms produced " + 
                (sortedCorrectly ? "identical" : "different") + " results.");
        }
    }

    private static List<Order> generateOrders(int count) {
        List<Order> orders = new ArrayList<>();
        Random random = new Random();
        String[] customerNames = {"John", "Alice", "Bob", "Carol", "David", "Eve", "Frank", "Grace"};
        
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        
        for (int i = 0; i < count; i++) {
            String orderId = "ORD" + String.format("%05d", i + 1);
            String customerName = customerNames[random.nextInt(customerNames.length)];
            double totalPrice = 10.0 + random.nextDouble() * 990.0; // Random price between 10 and 1000
            int itemCount = 1 + random.nextInt(10); // Random items between 1 and 10
            String orderDate = startDate.plusDays(random.nextInt(365)).toString();
            
            orders.add(new Order(orderId, customerName, totalPrice, itemCount, orderDate));
        }
        
        return orders;
    }

    private static void displayFirstNOrders(List<Order> orders, int n) {
        orders.stream()
              .limit(n)
              .forEach(System.out::println);
    }

    private static boolean validateSorting(List<Order> list1, List<Order> list2) {
        if (list1.size() != list2.size()) return false;
        
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getTotalPrice() != list2.get(i).getTotalPrice()) {
                return false;
            }
        }
        return true;
    }
}
