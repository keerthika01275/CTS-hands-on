package com.finance;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {
    private static Map<String, Double> memoizationCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Financial Forecasting Demo");
        System.out.println("=========================");

        // Test parameters
        double initialInvestment = 10000.0;
        double growthRate = 0.07; // 7% annual growth
        int years = 30;

        // 1. Simple Recursive Implementation
        System.out.println("\n1. Simple Recursive Implementation:");
        System.out.println("--------------------------------");
        
        long startTime = System.nanoTime();
        double futureValue = calculateFutureValueRecursive(initialInvestment, growthRate, years);
        long endTime = System.nanoTime();
        
        System.out.printf("Future value after %d years (Recursive): $%.2f%n", years, futureValue);
        System.out.printf("Calculation took %d nanoseconds%n", (endTime - startTime));

        // 2. Memoized Implementation
        System.out.println("\n2. Memoized Implementation:");
        System.out.println("-------------------------");
        
        memoizationCache.clear(); // Clear cache for fair comparison
        startTime = System.nanoTime();
        futureValue = calculateFutureValueMemoized(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        
        System.out.printf("Future value after %d years (Memoized): $%.2f%n", years, futureValue);
        System.out.printf("Calculation took %d nanoseconds%n", (endTime - startTime));

        // 3. Iterative Implementation (for comparison)
        System.out.println("\n3. Iterative Implementation:");
        System.out.println("---------------------------");
        
        startTime = System.nanoTime();
        futureValue = calculateFutureValueIterative(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        
        System.out.printf("Future value after %d years (Iterative): $%.2f%n", years, futureValue);
        System.out.printf("Calculation took %d nanoseconds%n", (endTime - startTime));

        // 4. Demonstrate with different scenarios
        System.out.println("\n4. Different Investment Scenarios:");
        System.out.println("--------------------------------");
        
        // Scenario 1: Conservative Growth
        demonstrateScenario(initialInvestment, 0.05, 10, "Conservative Growth (5%)");
        
        // Scenario 2: Aggressive Growth
        demonstrateScenario(initialInvestment, 0.12, 10, "Aggressive Growth (12%)");
        
        // Scenario 3: Long-term Investment
        demonstrateScenario(initialInvestment, growthRate, 40, "Long-term Investment (7%)");
    }

    /**
     * Simple recursive implementation
     * Time Complexity: O(2^n) due to recalculating same values multiple times
     * Space Complexity: O(n) due to recursion stack
     */
    private static double calculateFutureValueRecursive(double principal, double rate, int years) {
        // Base case
        if (years == 0) {
            return principal;
        }

        // Recursive case: FV = P(1 + r)^n
        return calculateFutureValueRecursive(principal, rate, years - 1) * (1 + rate);
    }

    /**
     * Memoized recursive implementation
     * Time Complexity: O(n) as each value is calculated only once
     * Space Complexity: O(n) for memoization cache plus recursion stack
     */
    private static double calculateFutureValueMemoized(double principal, double rate, int years) {
        // Create unique key for this combination
        String key = String.format("%.2f-%.2f-%d", principal, rate, years);

        // Check if result is already cached
        if (memoizationCache.containsKey(key)) {
            return memoizationCache.get(key);
        }

        // Base case
        if (years == 0) {
            return principal;
        }

        // Recursive case with memoization
        double result = calculateFutureValueMemoized(principal, rate, years - 1) * (1 + rate);
        memoizationCache.put(key, result);
        
        return result;
    }

    /**
     * Iterative implementation for comparison
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static double calculateFutureValueIterative(double principal, double rate, int years) {
        double result = principal;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    /**
     * Helper method to demonstrate different scenarios
     */
    private static void demonstrateScenario(double principal, double rate, int years, String scenarioName) {
        System.out.println("\nScenario: " + scenarioName);
        System.out.printf("Initial Investment: $%.2f%n", principal);
        System.out.printf("Annual Growth Rate: %.1f%%%n", rate * 100);
        System.out.printf("Time Period: %d years%n", years);

        // Clear cache for fair comparison
        memoizationCache.clear();

        // Using memoized version for efficiency
        double futureValue = calculateFutureValueMemoized(principal, rate, years);
        double totalReturn = ((futureValue - principal) / principal) * 100;

        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Return: %.1f%%%n", totalReturn);
    }
}
