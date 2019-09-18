package com.max;

public class DelimiterGenerator {

    public String[] generateCustomDelimiterRegex(String configuration) {
        String[] delimiterArr;

        if (hasLengthyOrMultipleDelimiters(configuration)) {
            delimiterArr = extractDelimiters(configuration);
        } else {
            delimiterArr = new String[] {String.valueOf(configuration.charAt(2))};
        }

        return delimiterArr;
    }

    public String[] extractDelimiters(String configuration) {
        return configuration.substring(3, configuration.length() - 1).split("\\Q][\\E");
    }

    private boolean hasLengthyOrMultipleDelimiters(String configuration) {
        return configuration.endsWith("]");
    }

}
