package com.dicksonkho.tutorial;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_age_less_than_20() {
        Calculator calculator = new Calculator();
        Assert.assertTrue(calculator.calculateInterestBasedOnAge(19) > 0);
    }

    @Test
    public void should_return_positive_value() {
        Calculator calculator = new Calculator();
        Assert.assertTrue(calculator.calculateInterestBasedOnAge(28) > 0);
    }
}
