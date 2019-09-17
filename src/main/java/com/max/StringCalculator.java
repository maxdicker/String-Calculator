package com.max;

public class StringCalculator {
    private DelimiterExtractor extractor;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
    }

    public int Add(String input) {
        if (!input.isBlank()) {
            return addNonEmptyString(input);
        }
        return 0;
    }

    private int addNonEmptyString(String input) throws NegativesException {
        String delimiter = "[,\n]";
        //Thinking it may be better to split input on \n, and pass the delimiter section to delimiter extractor and other half to adding function. The adding function already only takes one half anyway...
        int expressionStartingIndex = 0;

        if (input.startsWith("//")) {
            delimiter = extractor.generateCustomDelimiterRegex(input);
            expressionStartingIndex  = input.indexOf('\n') + 1;
        }

        var expressionArr = input.substring(expressionStartingIndex).split(delimiter);

        return addArrayOfStrings(expressionArr);
    }

    private int addArrayOfStrings(String[] expressionArr) {
        int sum = 0;

        for (String s : expressionArr) {
            int number = Integer.parseInt(s);

            if (number < 0) {
                throw new NegativesException("Negatives not allowed: " + number);
            } else if (number < 1000) {
                sum += number;
            }
        }

        return sum;
    }

}
