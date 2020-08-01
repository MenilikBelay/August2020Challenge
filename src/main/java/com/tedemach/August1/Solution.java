package com.tedemach.August1;

public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        boolean isCapital = isCapital(word.charAt(1)); // word needs to be capital all along
        if (isCapital && !isCapital(word.charAt(0)))
            return false;
        for (int i = 2; i < word.length(); i++) {
            if (isCapital ^ isCapital(word.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean isCapital(char c) {
        return 'A' <= c && c <= 'Z';
    }
}

/*
 * 
 * firstword: capital, small 
 * secondword: capital, small 
 * [3:] => replica of secondword format
 * 
 * 
 */