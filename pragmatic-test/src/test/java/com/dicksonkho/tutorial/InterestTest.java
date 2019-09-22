package com.dicksonkho.tutorial;

import org.junit.Assert;
import org.junit.Test;

public class InterestTest {

    @Test
    public void should_return_calculated_payment() {
        Interest interest = new Interest();
        Assert.assertEquals(4500, interest.calculateInterestAmount(5000, 2000, 1.5), 0.1);
    }
}
