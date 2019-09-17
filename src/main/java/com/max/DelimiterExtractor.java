package com.max;

public class DelimiterExtractor {

    public String generateCustomDelimiterRegex(String input) {
        String[] delimiterArr;

        if (hasLengthyOrMultipleDelimiters(input)) {
            delimiterArr = extractDelimiters(input);
        } else {
            delimiterArr = new String[] {String.valueOf(input.charAt(2))};
        }

        return transformDelimitersToRegex(delimiterArr);
    }

    public String[] extractDelimiters(String input) {
        int endOfDelimiterExpression = input.indexOf('\n');

        String delimiterExpression = input.substring(3, endOfDelimiterExpression - 1);
        return delimiterExpression.split("\\Q][\\E");
    }

    public String transformDelimitersToRegex(String[] delimiters) {
        String regex = "";

        for (String s : delimiters) {
            regex = regex + "|" + "\\Q" + s + "\\E";
        }

        return regex.substring(1);
    }

    private boolean hasLengthyOrMultipleDelimiters(String input) {
        return input.charAt(input.indexOf('\n') - 1) == ']';
    }

}
