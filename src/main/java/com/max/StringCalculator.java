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

        if (input.charAt(0) == '/') {
            delimiter = "[" + input.charAt(2) + "]";
            input = input.substring(4);
        }

        var stringArr = input.split(delimiter);

        for (String s : stringArr) {
            if (s.contains("-")) {
                throw new NegativesException("Negatives not allowed: " + s);
            }
                sum += Integer.parseInt(s);
        }

        return sum;
    }

}
