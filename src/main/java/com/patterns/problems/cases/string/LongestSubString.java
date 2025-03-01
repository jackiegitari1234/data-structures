package com.patterns.problems.cases.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubString {
    public static int solution(String s) {
        if (s == null || s.isEmpty()) return 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        for (int x = 0; x < s.length(); x++) {
            char currentChar = s.charAt(x);

            // If character is already in map and within the window, move left pointer
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }

            // Store/update the character's latest index
            charIndexMap.put(currentChar, x);

            // Update max length
            maxLength = Math.max(maxLength, x - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbabce";
            System.out.println( solution(input ));
    }
}
