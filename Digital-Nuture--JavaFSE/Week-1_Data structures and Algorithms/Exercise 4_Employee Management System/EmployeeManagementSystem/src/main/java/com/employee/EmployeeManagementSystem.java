package com.employee;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Employee Management System Demo");
        System.out.println("==============================");

        // Create employee array with capacity of 10
        EmployeeArray employeeArray = new EmployeeArray(10);

        // 1. Test Adding Employees
        System.out.println("\n1. Adding Employees:");
        System.out.println("-------------------");
        addTestEmployees(employeeArray);

        // 2. Display all employees
        System.out.println("\n2. Displaying All Employees:");
        System.out.println("---------------------------");
        employeeArray.displayAllEmployees();

        // 3. Search for employees
        System.out.println("\n3. Searching for Employees:");
        System.out.println("---------------------------");
        // Search for existing employee
        searchEmployee(employeeArray, 103);
        // Search for non-existent employee
        searchEmployee(employeeArray, 999);

        // 4. Update employee details
        System.out.println("\n4. Updating Employee Details:");
        System.out.println("-----------------------------");
        updateEmployee(employeeArray, 102);
        employeeArray.displayAllEmployees();

        // 5. Delete employees
        System.out.println("\n5. Deleting Employees:");
        System.out.println("----------------------");
        // Delete existing employee
        deleteEmployee(employeeArray, 101);
        // Try to delete non-existent employee
        deleteEmployee(employeeArray, 999);
        employeeArray.displayAllEmployees();

        // 6. Test array limits
        System.out.println("\n6. Testing Array Limits:");
        System.out.println("-----------------------");
        testArrayLimits(employeeArray);
    }

    private static void addTestEmployees(EmployeeArray array) {
        Employee[] testEmployees = {
            new Employee(101, "John Doe", "Software Engineer", 75000.0, "Engineering"),
            new Employee(102, "Jane Smith", "Project Manager", 85000.0, "Management"),
            new Employee(103, "Bob Johnson", "Senior Developer", 80000.0, "Engineering"),
            new Employee(104, "Alice Brown", "Business Analyst", 70000.0, "Business"),
            new Employee(105, "Charlie Wilson", "QA Engineer", 65000.0, "Quality Assurance")
        };

        for (Employee emp : testEmployees) {
            if (array.addEmployee(emp)) {
                System.out.println("Added: " + emp);
            }
        }
    }

    private static void searchEmployee(EmployeeArray array, int employeeId) {
        System.out.println("\nSearching for employee ID: " + employeeId);
        Employee found = array.findEmployeeById(employeeId);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    private static void updateEmployee(EmployeeArray array, int employeeId) {
        System.out.println("\nUpdating employee ID: " + employeeId);
        if (array.updateEmployee(employeeId, "Senior Project Manager", 95000.0, "Management")) {
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Failed to update employee");
        }
    }

    private static void deleteEmployee(EmployeeArray array, int employeeId) {
        System.out.println("\nDeleting employee ID: " + employeeId);
        if (array.deleteEmployee(employeeId)) {
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Failed to delete employee");
        }
    }

    private static void testArrayLimits(EmployeeArray array) {
        int remainingCapacity = array.getCapacity() - array.getSize();
        System.out.println("Testing array limits by adding " + (remainingCapacity + 1) + " more employees...");
        
        for (int i = 1; i <= remainingCapacity + 1; i++) {
            Employee emp = new Employee(
                200 + i,
                "Test Employee " + i,
                "Test Position",
                50000.0,
                "Test Department"
            );
            if (!array.addEmployee(emp)) {
                System.out.println("Array limit reached after adding " + (i-1) + " more employees");
                break;
            }
        }
    }
}
