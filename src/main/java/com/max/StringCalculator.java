package com.max;

public class StringCalculator {
    private DelimiterExtractor extractor;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
    }

    public int Add(String input) {
        if (!input.isBlank()) {
                return addNonEmptyInput(input);
        }
        return 0;
    }

    private int addNonEmptyInput(String input) throws NegativesException {
        String delimiter = "[,\n]";
        int expressionStartingIndex = 0;

        if (input.startsWith("//")) {
            delimiter = extractor.getCustomDelimiterRegex(input);
            expressionStartingIndex  = input.indexOf('\n') + 1;
        }

        var expressionArr = input.substring(expressionStartingIndex).split(delimiter);

        return addStringArray(expressionArr);
    }

    private int addStringArray(String[] expressionArr) {
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
