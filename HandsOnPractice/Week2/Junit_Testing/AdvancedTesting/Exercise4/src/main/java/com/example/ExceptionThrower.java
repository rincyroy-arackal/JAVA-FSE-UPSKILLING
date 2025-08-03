package com.example;

public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        // Some logic if input is valid
        System.out.println("Valid input: " + input);
    }
}
