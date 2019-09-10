package com.max;

public class StringCalculator
{
    public int Add(String s) {
        if (!s.isBlank()) {
            return Integer.parseInt(s);
        }
        return 0;
    }

}
