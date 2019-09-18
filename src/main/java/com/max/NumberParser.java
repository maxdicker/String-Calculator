package com.max;

public class NumberParser {

    public int[] getNumbers(String[] delimiters, String expression) {
        String regex = transformDelimitersToRegex(delimiters);
        return toIntArr(expression.split(regex));
    }

    public String transformDelimitersToRegex(String[] delimiters) {
        String regex = "";

        for (String s : delimiters) {
            regex = regex + "|" + "\\Q" + s + "\\E";
        }

        return regex.substring(1);
    }

    public int[] toIntArr(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }
}
