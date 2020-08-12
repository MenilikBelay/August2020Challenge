package com.tedemach.August3;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        int leftPtr = 0, rightPtr = s.length() - 1;
        s = s.toLowerCase();
        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && !isValid(s.charAt(leftPtr)))
                leftPtr++;
            while (leftPtr < rightPtr && !isValid(s.charAt(rightPtr)))
                rightPtr--;
            if (s.charAt(leftPtr) != s.charAt(rightPtr))
                return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}