package com.example.mvc;

public class MVCTest {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("S101", "Alice", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        System.out.println("Initial Student Record:");
        controller.updateView();

        // Update model data
        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        // Updated display
        System.out.println("\nUpdated Student Record:");
        controller.updateView();
    }
}
