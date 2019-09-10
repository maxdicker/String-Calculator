package com.max;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringCalculatorTest
{
    @Test
    public void testAddNothingReturnsZero()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.Add(""));
    }
}
