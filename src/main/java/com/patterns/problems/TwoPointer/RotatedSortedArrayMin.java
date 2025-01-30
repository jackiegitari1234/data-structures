package com.patterns.problems.TwoPointer;

public class RotatedSortedArrayMin {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("The minimum element is: " + findMin(nums)); // Output: 0
    }
}
