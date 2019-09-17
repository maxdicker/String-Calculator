package com.max;

public class DelimiterExtractor {

    public String getCustomDelimiterRegex (String input) {
        String[] delimiterArr;
        int endOfDelimiterExpression = input.indexOf('\n');

        if (input.charAt(endOfDelimiterExpression - 1) == ']') {
            delimiterArr = getDelimiters(input);
        } else {
            delimiterArr = new String[] {String.valueOf(input.charAt(2))};
        }

        return transformDelimitersToRegex(delimiterArr);
    }

    public String[] getDelimiters (String input) {
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

}
