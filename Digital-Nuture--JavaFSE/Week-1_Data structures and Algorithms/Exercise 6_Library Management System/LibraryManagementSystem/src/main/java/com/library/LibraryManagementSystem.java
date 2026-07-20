package com.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("Library Management System Demo");
        System.out.println("============================");

        // Create and populate book list
        List<Book> books = new ArrayList<>();
        populateBooks(books);

        // Create a sorted copy for binary search
        List<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);

        // 1. Linear Search Demonstration
        System.out.println("\n1. Linear Search Demonstration:");
        System.out.println("-----------------------------");
        
        // Search for existing book by title
        System.out.println("\nSearching for 'The Great Gatsby' using Linear Search:");
        Book foundLinear = SearchAlgorithms.linearSearchByTitle(books, "The Great Gatsby");
        displayResult(foundLinear);

        // Search for non-existent book
        System.out.println("\nSearching for 'Non-existent Book' using Linear Search:");
        foundLinear = SearchAlgorithms.linearSearchByTitle(books, "Non-existent Book");
        displayResult(foundLinear);

        // Search by author
        System.out.println("\nSearching for author 'George Orwell' using Linear Search:");
        Book foundByAuthor = SearchAlgorithms.linearSearchByAuthor(books, "George Orwell");
        displayResult(foundByAuthor);

        // 2. Binary Search Demonstration
        System.out.println("\n2. Binary Search Demonstration:");
        System.out.println("-----------------------------");
        
        // Display sorted books
        System.out.println("\nSorted Book List (by title):");
        for (Book book : sortedBooks) {
            System.out.println(book);
        }

        // Search for book in middle of list
        System.out.println("\nSearching for 'Pride and Prejudice' using Binary Search:");
        Book foundBinary = SearchAlgorithms.binarySearchByTitle(sortedBooks, "Pride and Prejudice");
        displayResult(foundBinary);

        // Search for book near start of list
        System.out.println("\nSearching for '1984' using Binary Search:");
        foundBinary = SearchAlgorithms.binarySearchByTitle(sortedBooks, "1984");
        displayResult(foundBinary);

        // Search for book near end of list
        System.out.println("\nSearching for 'The Great Gatsby' using Binary Search:");
        foundBinary = SearchAlgorithms.binarySearchByTitle(sortedBooks, "The Great Gatsby");
        displayResult(foundBinary);

        // Search for non-existent book
        System.out.println("\nSearching for 'Non-existent Book' using Binary Search:");
        foundBinary = SearchAlgorithms.binarySearchByTitle(sortedBooks, "Non-existent Book");
        displayResult(foundBinary);

        // 3. Performance Comparison
        System.out.println("\n3. Performance Comparison with Larger Dataset:");
        System.out.println("------------------------------------------");
        
        // Add more books to demonstrate performance difference
        for (int i = 0; i < 1000; i++) {
            books.add(new Book(1000 + i, 
                "Book " + (1000 + i), 
                "Author " + (1000 + i)));
        }
        List<Book> largeSortedList = new ArrayList<>(books);
        Collections.sort(largeSortedList);

        System.out.println("\nSearching in list of " + books.size() + " books:");
        
        // Search for last book using both methods
        String lastBookTitle = "Book 1999";
        System.out.println("\nSearching for '" + lastBookTitle + "':");
        
        System.out.println("\nLinear Search:");
        SearchAlgorithms.linearSearchByTitle(books, lastBookTitle);
        
        System.out.println("\nBinary Search:");
        SearchAlgorithms.binarySearchByTitle(largeSortedList, lastBookTitle);
    }

    private static void populateBooks(List<Book> books) {
        books.add(new Book(101, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(102, "1984", "George Orwell"));
        books.add(new Book(103, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(104, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(105, "Don Quixote", "Miguel de Cervantes"));
        books.add(new Book(106, "Moby Dick", "Herman Melville"));
        books.add(new Book(107, "War and Peace", "Leo Tolstoy"));
        books.add(new Book(108, "The Odyssey", "Homer"));
        books.add(new Book(109, "The Divine Comedy", "Dante Alighieri"));
        books.add(new Book(110, "Animal Farm", "George Orwell"));
    }

    private static void displayResult(Book book) {
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found");
        }
    }
}
