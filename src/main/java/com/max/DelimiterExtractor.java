package com.max;

public class DelimiterExtractor {

    public String[] getDelimitersFromExpression(String Expression) {
        String[] delimiters;

        if (hasLengthyOrMultipleDelimiters(Expression)) {
            delimiters = extractDelimiters(Expression);
        } else {
            delimiters = new String[] {String.valueOf(Expression.charAt(2))};
        }

        return delimiters;
    }

    private String[] extractDelimiters(String configuration) {
        return configuration.substring(3, configuration.length() - 1).split("\\Q][\\E");
    }

    private boolean hasLengthyOrMultipleDelimiters(String configuration) {
        return configuration.endsWith("]");
    }

}
