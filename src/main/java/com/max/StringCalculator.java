package com.max;

public class StringCalculator {

    public int Add(String input) {
        if (!input.isBlank()) {
                return AddNonEmptyInput(input);
        }
        return 0;
    }

    private int AddNonEmptyInput(String input) throws NegativesException {
        String delimiter = "[,\n]";
        int expressionStartingIndex = 0;

        if (input.startsWith("//")) {
            delimiter = DetermineCustomDelimiter(input);
            expressionStartingIndex  = input.indexOf('\n') + 1;
        }

        var expressionArr = input.substring(expressionStartingIndex).split(delimiter);

        return AddStringArray(expressionArr);
    }

    private String DetermineCustomDelimiter(String input) {
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

    private int AddStringArray(String[] expressionArr) {
        int sum = 0;

        for (String s : expressionArr) {
            if (s.contains("-")) {
                throw new NegativesException("Negatives not allowed: " + s);
            }
            int number = Integer.parseInt(s);
            if (number < 1000) {
                sum += Integer.parseInt(s);
            }
        }

        return sum;
    }

}
