package com.task;

public class TaskManagementSystem {
    public static void main(String[] args) {
        System.out.println("Task Management System Demo");
        System.out.println("=========================");

        // Create a new TaskLinkedList
        TaskLinkedList taskList = new TaskLinkedList();

        // 1. Test Adding Tasks
        System.out.println("\n1. Adding Tasks:");
        System.out.println("---------------");
        addTestTasks(taskList);

        // 2. Display all tasks
        System.out.println("\n2. Displaying All Tasks:");
        System.out.println("----------------------");
        taskList.displayAllTasks();

        // 3. Search for tasks
        System.out.println("\n3. Searching for Tasks:");
        System.out.println("---------------------");
        // Search for existing task
        searchTask(taskList, 103);
        // Search for non-existent task
        searchTask(taskList, 999);

        // 4. Delete tasks
        System.out.println("\n4. Deleting Tasks:");
        System.out.println("----------------");
        // Delete existing task
        deleteTask(taskList, 102);
        // Try to delete non-existent task
        deleteTask(taskList, 999);

        // Display final list
        taskList.displayAllTasks();

        // 5. Demonstrate dynamic nature
        System.out.println("\n5. Demonstrating Dynamic Nature:");
        System.out.println("-----------------------------");
        System.out.println("Adding more tasks to demonstrate dynamic growth...");
        
        // Add more tasks to demonstrate dynamic nature
        for (int i = 1; i <= 5; i++) {
            Task task = new Task(
                200 + i,
                "Dynamic Task " + i,
                "Pending"
            );
            taskList.appendTask(task);
            System.out.printf("Added task %d, Current size: %d%n", 200 + i, taskList.getSize());
        }

        // Display final state
        taskList.displayAllTasks();
    }

    private static void addTestTasks(TaskLinkedList list) {
        Task[] testTasks = {
            new Task(101, "Complete Project Proposal", "In Progress"),
            new Task(102, "Review Code Changes", "Pending"),
            new Task(103, "Update Documentation", "Completed"),
            new Task(104, "Fix Bug #1234", "In Progress"),
            new Task(105, "Deploy to Production", "Pending")
        };

        for (Task task : testTasks) {
            list.appendTask(task);
            System.out.println("Added: " + task);
        }
    }

    private static void searchTask(TaskLinkedList list, int taskId) {
        System.out.println("\nSearching for task ID: " + taskId);
        Task found = list.findTaskById(taskId);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    private static void deleteTask(TaskLinkedList list, int taskId) {
        System.out.println("\nDeleting task ID: " + taskId);
        if (list.deleteTask(taskId)) {
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Failed to delete task");
        }
    }
}
