package com.example.mvc;

public class StudentView {
    public void displayStudentDetails(String studentId, String studentName, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("ID    : " + studentId);
        System.out.println("Name  : " + studentName);
        System.out.println("Grade : " + studentGrade);
    }
}
