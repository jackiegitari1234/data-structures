package com.patterns.problems.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
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
