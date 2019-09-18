package com.max;

public class NumberParser {

    public int[] getNumbersFromExpression(String[] delimiters, String expression) {
        String regex = transformDelimitersToRegex(delimiters);
        return toIntArr(expression.split(regex));
    }

    private String transformDelimitersToRegex(String[] delimiters) {
        String regex = "";

        for (String s : delimiters) {
            regex = regex + "|" + "\\Q" + s + "\\E";
        }

        return regex.substring(1);
    }

    private int[] toIntArr(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }
}
