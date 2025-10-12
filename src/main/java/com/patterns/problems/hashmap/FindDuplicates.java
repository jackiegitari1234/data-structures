package com.patterns.problems.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return new ArrayList<>(duplicates);
    }

    public static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();

        // Count character frequencies
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Find the first char with count == 1
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] items = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(firstNonRepeatingChar("swiss"));
    }
}
