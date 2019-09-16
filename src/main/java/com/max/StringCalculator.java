package com.max;

public class StringCalculator {

    public int Add(String input) {
        if (!input.isBlank()) {
                return AddNonEmptyInput(input);
        }
        return 0;
    }

    private int AddNonEmptyInput(String input) throws NegativesException {
        int sum = 0;
        String delimiter = "[,\n]";
        int expressionStartingIndex = 0;

        if (input.startsWith("//")) {
            delimiter = determineCustomDelimiter(input);

            expressionStartingIndex  = input.indexOf('\n') + 1;

        }

        var expressionArr = input.substring(expressionStartingIndex).split(delimiter);

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

    public String determineCustomDelimiter(String input) {
        String customDelimiter = "";
        int endOfDelimiterChanger = input.indexOf('\n');

        if (input.charAt(endOfDelimiterChanger - 1) == ']') {
            String delimiterChange = input.substring(3, endOfDelimiterChanger - 1);
            var delimiterArr = delimiterChange.split("\\Q][\\E");

            for (String s : delimiterArr) {
                customDelimiter = customDelimiter + "\\Q" + s + "\\E" + "|";
            }

            customDelimiter = customDelimiter.substring(0, customDelimiter.length() - 1);
//            [\Q***\E|\Q%\E|]
            if (delimiterArr.length > 1) {
                customDelimiter = "[" + customDelimiter + "]";
            }

        } else {
            customDelimiter = input.substring(2, endOfDelimiterChanger);
        }
        return customDelimiter;
    }

}
