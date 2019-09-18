package com.max;

public class DelimiterGenerator {

    public String generateCustomDelimiterRegex(String configuration) {
        String[] delimiterArr;

        if (hasLengthyOrMultipleDelimiters(configuration)) {
            delimiterArr = extractDelimiters(configuration);
        } else {
            delimiterArr = new String[] {String.valueOf(configuration.charAt(2))};
        }

        return transformDelimitersToRegex(delimiterArr);
    }

    public String[] extractDelimiters(String configuration) {
        return configuration.substring(3, configuration.length() - 1).split("\\Q][\\E");
    }

    public String transformDelimitersToRegex(String[] delimiters) {
        String regex = "";

        for (String s : delimiters) {
            regex = regex + "|" + "\\Q" + s + "\\E";
        }

        return regex.substring(1);
    }

    private boolean hasLengthyOrMultipleDelimiters(String configuration) {
        return configuration.endsWith("]");
    }

}
