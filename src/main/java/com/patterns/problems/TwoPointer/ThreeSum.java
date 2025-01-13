package com.patterns.problems.TwoPointer;

import java.util.Arrays;

/**
 * Given an array of integers, nums, and an integer value, target,
 * determine if there are any three integers in nums whose sum is equal to the target,
 * that is, nums[i] + nums[j] + nums[k] == target.
 * Return TRUE if three such integers exist in the array. Otherwise, return FALSE
 *
 *
 *
 *Time Complexity :
 * Sorting the array:O(nlogn)
 * Two-pointer search for each element:O(n2) (worst case when iterating through the array).
 * Total: O(n2).
 */
public class ThreeSum {
    public static boolean hasThreeSum(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Second pointer
            int right = nums.length - 1; // Third pointer

            // Step 3: Two-pointer search
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return true; // Found the triplet
                } else if (sum < target) {
                    left++; // Increase the sum by moving left pointer to the right
                } else {
                    right--; // Decrease the sum by moving right pointer to the left
                }
            }
        }

        // Step 4: No triplet found
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3, 9};
        int target = 12;

        System.out.println(hasThreeSum2(nums, target)); // Output: true (12 + 3 + 9 = 24)
    }

    public static boolean hasThreeSum2(int[] array, int target){
        Arrays.sort(array);
        for (int x=0; x<array.length-2; x++){
            int left = x+1;
            int right =array.length-1;

            //test
            while (left < right) {
                int sum = array[x] + array[left] + array[right];
                if (target == sum) {
                    return true;
                }
                if (target > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
