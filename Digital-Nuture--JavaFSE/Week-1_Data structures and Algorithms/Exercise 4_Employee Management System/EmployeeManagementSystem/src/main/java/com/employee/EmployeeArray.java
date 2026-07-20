package com.employee;

public class EmployeeArray {
    private Employee[] employees;
    private int size;
    private final int capacity;

    // Constructor to initialize array with given capacity
    public EmployeeArray(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    /**
     * Add a new employee to the array
     * Time Complexity: O(1) if space available
     * Space Complexity: O(1)
     */
    public boolean addEmployee(Employee employee) {
        long startTime = System.nanoTime();
        
        if (size >= capacity) {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }

        employees[size++] = employee;
        
        long endTime = System.nanoTime();
        System.out.printf("Add operation took %d nanoseconds%n", (endTime - startTime));
        return true;
    }

    /**
     * Search for an employee by ID
     * Time Complexity: O(n) - linear search
     * Space Complexity: O(1)
     */
    public Employee findEmployeeById(int employeeId) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        for (int i = 0; i < size; i++) {
            comparisons++;
            if (employees[i].getEmployeeId() == employeeId) {
                long endTime = System.nanoTime();
                System.out.printf("Search operation took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return employees[i];
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Search operation took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return null;
    }

    /**
     * Delete an employee by ID
     * Time Complexity: O(n) - need to shift elements after deletion
     * Space Complexity: O(1)
     */
    public boolean deleteEmployee(int employeeId) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        // Find the employee
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        // If employee found, shift all elements to fill the gap
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;

            long endTime = System.nanoTime();
            System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
                (endTime - startTime), comparisons);
            return true;
        }

        long endTime = System.nanoTime();
        System.out.printf("Delete operation took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return false;
    }

    /**
     * Update employee details
     * Time Complexity: O(n) - need to find the employee first
     * Space Complexity: O(1)
     */
    public boolean updateEmployee(int employeeId, String newPosition, double newSalary, String newDepartment) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        for (int i = 0; i < size; i++) {
            comparisons++;
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i].setPosition(newPosition);
                employees[i].setSalary(newSalary);
                employees[i].setDepartment(newDepartment);

                long endTime = System.nanoTime();
                System.out.printf("Update operation took %d nanoseconds with %d comparisons%n", 
                    (endTime - startTime), comparisons);
                return true;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("Update operation took %d nanoseconds with %d comparisons%n", 
            (endTime - startTime), comparisons);
        return false;
    }

    /**
     * Display all employees
     * Time Complexity: O(n) - need to traverse all elements
     * Space Complexity: O(1)
     */
    public void displayAllEmployees() {
        long startTime = System.nanoTime();

        if (size == 0) {
            System.out.println("No employees in the system.");
            return;
        }

        System.out.println("\nEmployee List:");
        System.out.println("==============");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }

        long endTime = System.nanoTime();
        System.out.printf("Display operation took %d nanoseconds%n", (endTime - startTime));
    }

    /**
     * Get current size of the array
     */
    public int getSize() {
        return size;
    }

    /**
     * Get total capacity of the array
     */
    public int getCapacity() {
        return capacity;
    }
}
