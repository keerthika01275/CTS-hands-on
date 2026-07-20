package com.library;

import java.util.List;

public class SearchAlgorithms {
    
    /**
     * Linear Search implementation
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Book linearSearchByTitle(List<Book> books, String title) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        for (Book book : books) {
            comparisons++;
            if (book.getTitle().equalsIgnoreCase(title)) {
                long endTime = System.nanoTime();
                System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return book;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Linear Search by Author
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Book linearSearchByAuthor(List<Book> books, String author) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        for (Book book : books) {
            comparisons++;
            if (book.getAuthor().equalsIgnoreCase(author)) {
                long endTime = System.nanoTime();
                System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return book;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Linear Search took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Binary Search implementation (iterative)
     * Requires the list to be sorted by title
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Book binarySearchByTitle(List<Book> books, String title) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);
            
            if (comparison == 0) {
                long endTime = System.nanoTime();
                System.out.printf("Binary Search took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return books.get(mid);
            }
            
            if (comparison < 0) {
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
}
