package com.patterns.problems.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSm {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] items = { 2, 3, 4};
        System.out.println(Arrays.toString(twoSum(items, 6)));
    }
}
