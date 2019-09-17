package com.max;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DelimiterExtractorTest {
    private DelimiterExtractor extractor;

    @Before
    public void setUp() {
        extractor = new DelimiterExtractor();
    }

    @Test
    public void returnsBasicDelimiterRegex()
    {
        assertEquals("\\Q;\\E", extractor.generateCustomDelimiterRegex("//;\n1;2"));
    }

    @Test
    public void canReturnLengthyDelimiterRegex()
    {
        assertEquals("\\Q***\\E", extractor.generateCustomDelimiterRegex("//[***]\n1***2***3"));
    }

    @Test
    public void canExtractMultipleDelimiters()
    {
        String[] delimiters = extractor.extractDelimiters("//[asdf][qwerty]\n");

        assertEquals(2, delimiters.length);
        assertEquals("asdf", delimiters[0]);
        assertEquals("qwerty", delimiters[1]);
    }

    @Test
    public void canMakeRegexFromBasicDelimiter()
    {
        String[] delimiters = {";"};
        assertEquals("\\Q;\\E", extractor.transformDelimitersToRegex(delimiters));
    }

    @Test
    public void canMakeRegexFromLengthyDelimiter()
    {
        String[] delimiters = {"***"};
        assertEquals("\\Q***\\E", extractor.transformDelimitersToRegex(delimiters));
    }

    @Test
    public void canMakeRegexFromMultipleDelimiters()
    {
        String[] delimiters = {"***", ";", "$1$"};
        assertEquals("\\Q***\\E|\\Q;\\E|\\Q$1$\\E", extractor.transformDelimitersToRegex(delimiters));
    }
}
