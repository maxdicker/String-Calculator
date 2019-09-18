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
    public void returnsBasicDelimiter()
    {
        assertArrayEquals(new String[] {";"}, extractor.getDelimitersFromExpression("//;"));
    }

    @Test
    public void returnsLengthyDelimiter()
    {
        assertArrayEquals(new String[] {"***"}, extractor.getDelimitersFromExpression("//[***]"));
    }

    @Test
    public void returnsComplexDelimiters()
    {
        assertArrayEquals(new String[] {"*1*", "#", "%"}, extractor.getDelimitersFromExpression("//[*1*][#][%]"));
    }

}
