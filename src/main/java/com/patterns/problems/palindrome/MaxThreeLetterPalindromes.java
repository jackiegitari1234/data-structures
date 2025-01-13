package com.patterns.problems.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S made of N letters,
 * return the max number of three-letter palindromes
 * you can build using letters from S.
 * You can use each letter from S once
 * S=aaaabc , 2
 * S=xyvzwy, 1
 * S=dd, 0
 * S=fknfkn, 2
 */

public class MaxThreeLetterPalindromes {
    public static int maxThreeLetterPalindromes(String S) {
        // Count the frequency of each letter
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int palindromeCount = 0;

        // Loop to form palindromes
        while (true) {
            char a = 0, b = 0;

            // Find a letter with at least 2 occurrences for 'a'
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() >= 2) {
                    a = entry.getKey();
                    break;
                }
            }

            // Find a letter with at least 1 occurrence for 'b'
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() >= 1 && entry.getKey() != a) {
                    b = entry.getKey();
                    break;
                }
            }

            // Check if we can form a palindrome
            if (a != 0 && b != 0) {
                palindromeCount++;
                frequencyMap.put(a, frequencyMap.get(a) - 2);
                frequencyMap.put(b, frequencyMap.get(b) - 1);
            } else if (a != 0 && frequencyMap.get(a) >= 3) {// Check if the middle can also be the same as the ends

                palindromeCount++;
                frequencyMap.put(a, frequencyMap.get(a) - 3);
            } else {
                break;
            }

            // Remove characters with no remaining occurrences
//            frequencyMap.values().removeIf(count -> count <= 0);
            frequencyMap.entrySet().removeIf(entry -> entry.getValue() <= 0);

        }

        return palindromeCount;
    }

    public static void main(String[] args) {
//        String S = "dd";
        String S = "fknfkn";
//        String S = "xyvzwy";
//        String S = "aaaabc";
        System.out.println("Max three-letter palindromes: " + maxThreeLetterPalindromes2(S));
    }

    public static int maxThreeLetterPalindromes2(String S) {
        Map<Character, Integer> occurences = new HashMap<>();
        int parids = 0;
        for (Character c : S.toCharArray()) {
            occurences.put(c, occurences.getOrDefault(c, 0) + 1);
        }
        while (true) {
            Character a = 0;
            Character b = 0;
            for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {
                if (entry.getValue() >= 2) {
                    a = entry.getKey();
                    break;
                }
            }
            for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {

                if (entry.getValue() >= 1 && entry.getKey() != a) {
                    b = entry.getKey();
                    break;
                }
            }

            if (a != 0 && b != 0) {
                parids++;
                occurences.put(a, occurences.get(a) - 2);
                occurences.put(b, occurences.get(b) - 1);
            } else if (a != 0 && occurences.get(a) >= 3) {
                parids++;
                occurences.put(a, occurences.get(a) - 3);
            } else {
                break;
            }
            occurences.entrySet().removeIf(entr -> entr.getValue() <= 0);
        }

        return parids;

    }
}
