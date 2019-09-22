package com.dicksonkho.tutorial;

import org.junit.Assert;
import org.junit.Test;

public class InterestServiceIT {

    @Test
    public void should_get_monthly_payment() {
        InterestService service = new InterestService();
        Assert.assertEquals(100, service.getMonthlyPayment(30, 5000, 1000), 0.1);
    }
}
