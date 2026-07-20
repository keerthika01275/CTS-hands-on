package com.mvc;

public class MVCTest {
    public static void main(String[] args) {
        // Fetch student record based on his roll no from the database
        Student model = retriveStudentFromDatabase();

        // Create a view to show student details
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(model, view);

        // Display initial student details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update student information using controller
        System.out.println("\nUpdating student details...");
        
        // Test valid updates
        controller.setStudentName("John Smith");
        controller.setStudentGrade("A+");
        
        // Display updated student details
        System.out.println("\nFinal Student Details:");
        controller.updateView();

        // Test validation with invalid data
        System.out.println("\nTesting validation:");
        controller.setStudentName("");  // Should show error
        controller.setStudentGrade(null);  // Should show error
    }

    // Simulate retrieving student from a database
    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        student.setGrade("B");
        return student;
    }
}
