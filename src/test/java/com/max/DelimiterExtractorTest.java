package com.max;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DelimiterExtractorTest {
    private DelimiterExtractor extractor;

    @Before
    public void setUp() throws Exception {
        extractor = new DelimiterExtractor();
    }

    @Test
    public void canReturnBasicDelimiter()
    {
        assertEquals(";", extractor.getCustomDelimiter("//;\n1;2"));
    }

    @Test
    public void canReturnLengthyDelimiter()
    {
        assertEquals("\\Q***\\E", extractor.getCustomDelimiter("//[***]\n1***2***3"));
    }

    @Test
    public void canExtractMultipleDelimiters()
    {
        String[] delimiters = extractor.getDelimiters("//[asdf][qwerty]\n");

        assertEquals(2, delimiters.length);
        assertEquals("asdf", delimiters[0]);
        assertEquals("qwerty", delimiters[1]);
    }

    
}
