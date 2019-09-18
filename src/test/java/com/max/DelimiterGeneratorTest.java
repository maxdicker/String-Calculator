package com.max;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DelimiterGeneratorTest {
    private DelimiterGenerator extractor;

    @Before
    public void setUp() {
        extractor = new DelimiterGenerator();
    }

    @Test
    public void returnsBasicDelimiterRegex()
    {
        assertEquals("\\Q;\\E", extractor.generateCustomDelimiterRegex("//;"));
    }

    @Test
    public void canReturnLengthyDelimiterRegex()
    {
        assertEquals("\\Q***\\E", extractor.generateCustomDelimiterRegex("//[***]"));
    }

    @Test
    public void canExtractMultipleDelimiters()
    {
        String[] delimiters = extractor.extractDelimiters("//[asdf][qwerty]");

        assertEquals(2, delimiters.length);
        assertEquals("asdf", delimiters[0]);
        assertEquals("qwerty", delimiters[1]);
    }

}
