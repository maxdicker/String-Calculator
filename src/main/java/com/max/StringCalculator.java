package com.max;

public class StringCalculator {
    private DelimiterExtractor extractor;
    private NumberParser parser;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
        this.parser = new NumberParser();
    }

    public int Add(String input) {
        if (!input.isBlank()) {
            return addNonEmptyString(input);
        }
        return 0;
    }

    private int addNonEmptyString(String input) throws NegativesException {
        String[] delimiters;
        String expression;

        if (input.startsWith("//")) {
            String[] inputArr = input.split("\n");
            delimiters = extractor.getDelimitersFromExpression(inputArr[0]);
            expression = inputArr[1];
        } else {
            delimiters = new String[] {",", "\n"};
            expression = input;
        }

        int[] numbers = parser.getNumbersFromExpression(delimiters, expression);

        return sum(numbers);
    }

    private int sum(int[] numbers) {
        int sum = 0;

        for (int i : numbers) {
            if (i < 0) {
                throw new NegativesException("Negatives not allowed: " + i);
            } else if (i < 1000) {
                sum += i;
            }
        }

        return sum;
    }

}
