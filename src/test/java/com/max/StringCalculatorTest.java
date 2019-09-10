package com.max;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testAddEmptyReturnsZero()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void testAddANumberReturnsThatNumber()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.Add("3"));
    }

    @Test
    public void testAddingTwoNumbersReturnsTheSum()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(8, calculator.Add("3,5"));
    }

    @Test
    public void testAddingManyNumbersReturnsTheSum()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(20, calculator.Add("3,5,3,9"));
    }

    @Test
    public void testNewLineBreaksAndCommasAreInterchangeable()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(20, calculator.Add("3\n5\n3,9"));
    }

    @Test
    public void testAddMethodSupportsDifferentDelimiters()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.Add("//;\n1;2"));
    }

    @Test (expected = NegativesException.class)
    public void testAddMethodThrowsExceptionWithNegativeNumbers()
    {
        StringCalculator calculator = new StringCalculator();
        calculator.Add("-1,2,-3");
    }
}
