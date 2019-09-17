package com.max;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DelimiterExtractorTest {

    @Test
    public void testDelimiterExtractor()
    {
        DelimiterExtractor extractor = new DelimiterExtractor();
        assertEquals(";", extractor.DetermineCustomDelimiter("//;\n1;2"));
    }
}
