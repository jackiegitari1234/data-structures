package com.patterns.problems.hashmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/** Given an integer array nums,
 *return true if any value appears at least twice in the array,
 *  and return false if every element is distinct.
 */
public class Duplicates {

    static boolean findDuplicates(int[] nums){
        Set<Integer> set = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return nums.length != set.size();
//        Map<Integer, Integer> items = new HashMap<>();
//        for (int x = 0; x< array.length; x++){
//            if (items.containsKey(array[x])){
//                return true;
//            }
//            items.put(array[x], x);
//        }
//        return false;
    }

    public static void main(String[] args) {
        int[] items = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(findDuplicates(items));
    }
}
