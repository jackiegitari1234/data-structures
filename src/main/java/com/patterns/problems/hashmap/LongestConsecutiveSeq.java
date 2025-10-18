package com.patterns.problems.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] items = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(longestConsecutiveSequence(items));
    }

}
