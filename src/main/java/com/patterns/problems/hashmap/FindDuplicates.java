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

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> newList = new HashSet<>(myList);
        return new ArrayList<>(newList);

    }

    public static boolean hasUniqueChars(String string) {
        if (string.length() > 128) {
            return false;
        }
        char[] arrayList = string.toCharArray();
        Set<Character> items = new HashSet<>();
        for (char c : arrayList) {
            if (!items.add(c)) return false;
        }
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> set1 = new HashSet<>();
        for (int c : arr1) {
            set1.add(c);
        }
        List<int[]> lists = new ArrayList<>();
        for (int i : arr2) {
            if (set1.contains(target - i)) {
                lists.add(new int[]{target - i, i});
            }

        }
        return lists;
    }


    public static void main(String[] args) {
        int[] items2 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        List<Integer> newList = Arrays.asList(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);

        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 8, 10}, 7));
    }
}
