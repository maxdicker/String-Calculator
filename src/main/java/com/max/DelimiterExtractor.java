package com.max;

public class DelimiterExtractor {

    public String DetermineCustomDelimiter(String input) {
        String customDelimiter = "";
        int endOfDelimiterExpression = input.indexOf('\n');

        if (input.charAt(endOfDelimiterExpression - 1) == ']') {
            String delimiterExpression = input.substring(3, endOfDelimiterExpression - 1);
            var delimiterArr = delimiterExpression.split("\\Q][\\E");

            for (String s : delimiterArr) {
                customDelimiter = customDelimiter + "|" + "\\Q" + s + "\\E";
            }

            customDelimiter = customDelimiter.substring(1);

        } else {
            customDelimiter = input.substring(2, endOfDelimiterExpression);
        }

        return customDelimiter;
    }
}
