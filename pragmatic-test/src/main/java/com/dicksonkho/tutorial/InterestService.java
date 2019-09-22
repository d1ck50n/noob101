package com.dicksonkho.tutorial;

public class InterestService {

    private static final int PAYMENT_TERM_MONTH = 60;

    public double getMonthlyPayment(int age, double price, double downPayment) {
        Calculator calculator = new Calculator();
        Interest interest = new Interest();

        double interestRate = calculator.calculateInterestBasedOnAge(age);
        double totalAmount = interest.calculateInterestAmount(price, downPayment, interestRate);
        double monthlyPayment = totalAmount / PAYMENT_TERM_MONTH;
        return monthlyPayment;
    }
}
