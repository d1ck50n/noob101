package com.dicksonkho.tutorial;

public class Calculator {

    private static final double FIXED_INTEREST_RATE = 0.05;

    protected double calculateInterestBasedOnAge(int age) {
        if (age < 20) {
            throw new RuntimeException("Age must be more than 20");
        }
        return age * FIXED_INTEREST_RATE;
    }
}
