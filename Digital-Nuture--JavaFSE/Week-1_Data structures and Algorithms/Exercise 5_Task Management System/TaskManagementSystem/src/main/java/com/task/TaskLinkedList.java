package com.task;

public class TaskLinkedList {
    private TaskNode head;
    private int size;

    public TaskLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Add a task to the beginning of the list (prepend)
     * Time Complexity: O(1)
     */
    public void addTask(Task task) {
        long startTime = System.nanoTime();

        TaskNode newNode = new TaskNode(task);
        newNode.setNext(head);
        head = newNode;
        size++;

        long endTime = System.nanoTime();
        System.out.printf("Add operation took %d nanoseconds%n", (endTime - startTime));
    }

    /**
     * Add a task to the end of the list (append)
     * Time Complexity: O(n)
     */
    public void appendTask(Task task) {
        long startTime = System.nanoTime();

        TaskNode newNode = new TaskNode(task);
        
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;

        long endTime = System.nanoTime();
        System.out.printf("Append operation took %d nanoseconds%n", (endTime - startTime));
    }

    /**
     * Search for a task by ID
     * Time Complexity: O(n)
     */
    public Task findTaskById(int taskId) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        TaskNode current = head;
        while (current != null) {
            comparisons++;
            if (current.getTask().getTaskId() == taskId) {
                long endTime = System.nanoTime();
                System.out.printf("Search operation took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return current.getTask();
            }
            current = current.getNext();
        }

        long endTime = System.nanoTime();
        System.out.printf("Search operation took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Delete a task by ID
     * Time Complexity: O(n)
     */
    public boolean deleteTask(int taskId) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        if (head == null) {
            long endTime = System.nanoTime();
            System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
                (endTime - startTime), comparisons);
            return false;
        }

        // If head node itself holds the task to be deleted
        comparisons++;
        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            size--;
            long endTime = System.nanoTime();
            System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
                (endTime - startTime), comparisons);
            return true;
        }

        // Search for the task to be deleted
        TaskNode current = head;
        TaskNode prev = null;

        while (current != null && current.getTask().getTaskId() != taskId) {
            comparisons++;
            prev = current;
            current = current.getNext();
        }

        // If task not found
        if (current == null) {
            long endTime = System.nanoTime();
            System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
                (endTime - startTime), comparisons);
            return false;
        }

        // Unlink the node from linked list
        prev.setNext(current.getNext());
        size--;

        long endTime = System.nanoTime();
        System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return true;
    }

    /**
     * Display all tasks in the list
     * Time Complexity: O(n)
     */
    public void displayAllTasks() {
        long startTime = System.nanoTime();

        if (head == null) {
            System.out.println("No tasks in the system.");
            return;
        }

        System.out.println("\nTask List:");
        System.out.println("==========");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.getTask());
            current = current.getNext();
        }

        long endTime = System.nanoTime();
        System.out.printf("Display operation took %d nanoseconds%n", (endTime - startTime));
    }

    /**
     * Get the current size of the list
     */
    public int getSize() {
        return size;
    }
}
