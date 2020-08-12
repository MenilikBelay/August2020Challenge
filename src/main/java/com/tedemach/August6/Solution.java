package com.tedemach.August6;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val < 0)
                val = -val;
            if (nums[val - 1] < 0)
                duplicates.add(val);
            else
                nums[val - 1] = -nums[val - 1];
        }
        return duplicates;
    }
}