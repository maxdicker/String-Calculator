package com.max;

public class StringCalculator {
    private DelimiterGenerator extractor;

    public StringCalculator() {
        this.extractor = new DelimiterGenerator();
    }

    public int Add(String input) {
        if (!input.isBlank()) {
            return addNonEmptyString(input);
        }
        return 0;
    }

    private int addNonEmptyString(String input) throws NegativesException {
        String delimiter = "[,\n]";
        String expression = input;

        if (input.startsWith("//")) {
            String[] inputArr = input.split("\n");
            delimiter = extractor.generateCustomDelimiterRegex(inputArr[0]);
            expression = inputArr[1];
        }

        var expressionArr = expression.split(delimiter);

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
