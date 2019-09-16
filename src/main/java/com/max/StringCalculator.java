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
            delimiter = "";
            int endOfDelimiterChanger = input.indexOf('\n');

            if (input.charAt(endOfDelimiterChanger - 1) == ']') {
                String delimiterChange = input.substring(3, endOfDelimiterChanger - 1);
                var delimiterArr = delimiterChange.split("\\Q][\\E");

                for (String s : delimiterArr) {
                    delimiter = delimiter + "\\Q" + s + "\\E";
                }

                if (delimiterArr.length > 1) {
                    delimiter = "[" + delimiter + "]";
                }
            } else {
                delimiter = input.substring(2, endOfDelimiterChanger);
            }

            input = input.substring(endOfDelimiterChanger + 1);

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
