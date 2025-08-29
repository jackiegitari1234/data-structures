package com.patterns.problems.cases.binary;

import java.util.ArrayList;
import java.util.List;

//You were given a list of strings, and for each string, you needed to:
//
//    Count sequences of consecutive vowels.
//
//    Award a point to Chris if the vowel sequence length is even, and to Alex if it's odd.
//
//    Compare total scores for each name per string to decide the winner.
//
//    In case of a tie, the win defaults to Chris.
public class HammingWeight2 {

    public static List<String> getWho(List<String> s) {
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        List<String> winners = new ArrayList<>();

        for (String string : s) {
            int currentCount = 0;
            int chrisCount = 0;
            int alexCount = 0;

            for (char c : string.toCharArray()) {
                if (vowels.contains(String.valueOf(c))) {
                    currentCount++;
                } else {
                    if (currentCount > 0) {
                        if (currentCount % 2 == 0) {
                            chrisCount++;
                        } else {
                            alexCount++;
                        }
                        currentCount = 0;
                    }
                }
            }

            // Handle remaining vowel streak at the end
            if (currentCount > 0) {
                if (currentCount % 2 == 0) {
                    chrisCount++;
                } else {
                    alexCount++;
                }
            }

            if (chrisCount > alexCount) {
                winners.add("Chris");
            } else if (alexCount > chrisCount) {
                winners.add("Alex");
            } else {
                winners.add("Chris"); // tie-breaker
            }
        }

        return winners;
    }


    public static void main(String[] args) {
        List<String> sample = new ArrayList<>(List.of("lgzpc", "lchxlo", "xrwzg"));
        int n = 29; // Example input
        System.out.println("Number of set bits: " + getWho(sample)); // Output: 4
    }
    
}
