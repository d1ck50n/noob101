package com.dicksonkho.tutorial;

public class Interest {

    protected double calculateInterestAmount(double price, double downPayment, double interestRate) {
        return (price - downPayment) * interestRate;
    }
}
