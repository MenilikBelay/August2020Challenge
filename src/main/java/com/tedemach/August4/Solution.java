package com.tedemach.August4;

public class Solution {
    public boolean isPowerOfFour(int num) {
        // one solution is using math
        // double logNum = Math.log(num)/Math.log(4);
        // return num > 0 && logNum == (int)(logNum);

        // other solution is using bit-wise operations
        // only one bit is set, one minus the number is divisible by three
        return num > 0 && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
    }
}

/*
 * 
 * 4, 16, 64, 256, 1024, 4096 100, 10000, 1000000, 100000000, 10000000000 2, 4,
 * 6, 8, 10
 * 
 * 
 * 
 * 
 * 
 */