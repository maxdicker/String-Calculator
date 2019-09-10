package com.max;

public class StringCalculator {

    public int Add(String input) {

        if (!input.isBlank()) {

            try {
                return AddNonEmptyInput(input);
            } catch (NegativesException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return 0;
    }

    private int AddNonEmptyInput(String input) throws NegativesException {
        int sum = 0;

        if (input.charAt(0) == '/') {

        }
        
        var stringArr = input.split("\\D");
        for (String s : stringArr) {
            if (s.contains("-")) {
                throw new NegativesException("Negatives not allowed: " + s);
            }
            if (!s.isBlank()) {
                sum += Integer.parseInt(s);
            }
        }

        return sum;
    }

}
