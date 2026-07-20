package com.mvc;

public class StudentView {
    public void displayStudentDetails(String studentRollNo, String studentName, String studentGrade) {
        System.out.println("\nStudent Details:");
        System.out.println("Roll No: " + studentRollNo);
        System.out.println("Name: " + studentName);
        System.out.println("Grade: " + studentGrade);
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println("\nError: " + errorMessage);
    }

    public void displayUpdateSuccess(String field) {
        System.out.println("\nSuccess: Student " + field + " updated successfully!");
    }
}
