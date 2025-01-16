package com.patterns.problems.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
public class ThreeSumZero {
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for nums[i]

            int left = i + 1, right = nums.length - 1; // Two pointers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicates for nums[left] and nums[right]
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        for (int x=0; x<nums.length-2; x++){
            if (x>0 && nums[x] == nums[x-1]) continue;
            int left = x+1;
            int right = nums.length-1;
            while (left<right) {
                int sum = nums[x] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> resp = Arrays.asList(nums[x], nums[left], nums[right]);
                    response.add(resp);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return response;
    }
        public static void main(String[] args) {
        ThreeSumZero solution = new ThreeSumZero();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
