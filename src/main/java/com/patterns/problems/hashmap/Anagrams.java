package com.patterns.problems.hashmap;

import java.util.*;

public class Anagrams {

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                map.put(sorted, group);
            }
        }

        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        String[] items = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(items));
    }
}
