package com.max;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberParserTest {
    private NumberParser parser;

    @Before
    public void setUp() {
        parser = new NumberParser();
    }

    @Test
    public void returnsNumbersWithBasicDelimiters()
    {
        assertArrayEquals(new int[] {1, 2, 3}, parser.getNumbersFromExpression(new String[] {";"}, "1;2;3"));
    }

    @Test
    public void returnsNumbersWithComplexDelimiters()
    {
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, parser.getNumbersFromExpression(new String[] {"*1*", "#", "%"}, "1*1*2%3*1*4#5"));
    }

    @Test
    public void toIntArray()
    {
        assertArrayEquals(new int[] {1, 2, 3}, parser.toIntArr(new String[] {"1", "2", "3"}));
    }

    @Test
    public void canMakeRegexFromBasicDelimiter()
    {
        String[] delimiters = {";"};
        assertEquals("\\Q;\\E", parser.transformDelimitersToRegex(delimiters));
    }

    @Test
    public void canMakeRegexFromLengthyDelimiter()
    {
        String[] delimiters = {"***"};
        assertEquals("\\Q***\\E", parser.transformDelimitersToRegex(delimiters));
    }

    @Test
    public void canMakeRegexFromMultipleDelimiters()
    {
        String[] delimiters = {"***", ";", "$1$"};
        assertEquals("\\Q***\\E|\\Q;\\E|\\Q$1$\\E", parser.transformDelimitersToRegex(delimiters));
    }
}
