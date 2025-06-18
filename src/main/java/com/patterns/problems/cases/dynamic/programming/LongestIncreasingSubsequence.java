package com.patterns.problems.cases.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    //Dynamic Programming (O(n²))
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] options = new int[nums.length];
        Arrays.fill(options, 1); // Every element is an increasing subsequence of length 1

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    options[i] = Math.max(options[i], options[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, options[i]);
        }
        return maxLength;
    }

    //Binary Search + DP (O(n log n))
    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);

            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4
    }
}

