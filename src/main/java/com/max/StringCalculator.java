package com.max;

import java.util.ArrayList;
import java.util.StringJoiner;

public class StringCalculator {
    private DelimiterExtractor extractor;
    private NumberParser parser;
    private String[] defaultDelimiters;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
        this.parser = new NumberParser();
        this.defaultDelimiters = new String[] {",", "\n"};
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
            return defaultDelimiters;
        }
    }

    private void throwExceptionIfContainsNegatives(int[] numbers) {
        ArrayList<Integer> negNumbers = getNegatives(numbers);
        StringJoiner negNumbersSJ = new StringJoiner(", ");

        for (Integer i : negNumbers) {
            negNumbersSJ.add(i.toString());
        }

        if (!negNumbers.isEmpty()) {
            throw new NegativesException("Negatives not allowed: " + negNumbersSJ);
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

    private int sum(int[] numbers) {
        int sum = 0;

        for (int i : numbers) {
            if (i < 1000) {
                sum += i;
            }
        }

        return sum;
    }

}
