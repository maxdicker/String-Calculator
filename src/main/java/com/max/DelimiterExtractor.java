package com.max;

public class DelimiterExtractor {

    public String getCustomDelimiter(String input) {
        String customDelimiter = "";
        int endOfDelimiterExpression = input.indexOf('\n');

        if (input.charAt(endOfDelimiterExpression - 1) == ']') {
            var delimiterArr = getDelimiters(input);

            for (String s : delimiterArr) {
                customDelimiter = customDelimiter + "|" + "\\Q" + s + "\\E";
            }

            customDelimiter = customDelimiter.substring(1);

        } else {
            customDelimiter = input.substring(2, endOfDelimiterExpression);
        }

        return customDelimiter;
    }

    public String[] getDelimiters(String input) {
        int endOfDelimiterExpression = input.indexOf('\n');

        String delimiterExpression = input.substring(3, endOfDelimiterExpression - 1);
        return delimiterExpression.split("\\Q][\\E");
    }
}
