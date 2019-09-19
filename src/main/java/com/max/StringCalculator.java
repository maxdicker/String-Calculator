package com.max;

import java.util.ArrayList;

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
        String[] delimiters = getDelimiters(input);
        String expression = getExpression(input);

        int[] numbers = parser.getNumbersFromExpression(delimiters, expression);

        throwExceptionIfContainsNegatives(numbers);

        return sum(numbers);
    }

    private void throwExceptionIfContainsNegatives(int[] numbers) {
        ArrayList<Integer> negativeNumbers = getNegatives(numbers);
        if (!negativeNumbers.isEmpty()) {
            throw new NegativesException("Negatives not allowed: " + negativeNumbers.toString().substring(1, negativeNumbers.toString().length()-1));
        }
    }

    private int sum(int[] numbers) {
        int sum = 0;

        for (int i : numbers) {
            if (i < 1000) {
                sum += i;
            }
        }

        return sum;
    }

    private String getExpression(String input) {
        if (input.startsWith("//")) {
            String[] inputArr = input.split("\n");
            return inputArr[1];
        } else {
            return input;
        }
    }

    private String[] getDelimiters(String input) {
        if (input.startsWith("//")) {
            String[] inputArr = input.split("\n");
            return extractor.getDelimitersFromExpression(inputArr[0]);
        } else {
            return new String[] {",", "\n"};
        }
    }

    private ArrayList<Integer> getNegatives(int[] numbers) {
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int i : numbers) {
            if (i < 0) {
                negatives.add(i);
            }
        }
        return negatives;
    }

}
