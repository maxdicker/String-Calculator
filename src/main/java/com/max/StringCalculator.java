package com.max;

public class StringCalculator {

    public int Add(String input) {
        int sum = 0;
        if (!input.isBlank()) {
            var stringArr = input.split("\\D");
            for (String s : stringArr) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

}
