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

        if (input.startsWith("//")) {
            int endOfDelimiter = input.indexOf('\n');
            delimiter = "";

            for (int i = 2; i < endOfDelimiter; i++) {
                delimiter += input.charAt(i);
            }

            if (delimiter.length() > 1) {
                delimiter = delimiter.substring(delimiter.indexOf('[') + 1, delimiter.indexOf(']'));
                delimiter = "\\Q" + delimiter + "\\E";
            }

            input = input.substring(endOfDelimiter + 1);
        }

        var stringArr = input.split(delimiter);

        for (String s : stringArr) {
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
