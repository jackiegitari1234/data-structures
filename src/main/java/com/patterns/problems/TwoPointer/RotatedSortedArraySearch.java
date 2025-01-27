package com.patterns.problems.TwoPointer;

public class RotatedSortedArraySearch {
    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        // Target is not found
        return -1;
    }

    public static int search(int[] nums, int target){
        int left =0;
        int right = nums.length-1;
        while (left <= right){
            int midIndex = (right+left)/2;
            if (target == nums[midIndex]) return midIndex;
            if (nums[left] <= nums[midIndex] ){
                if (nums[left] <= target && target < nums[midIndex]){
                    right = midIndex-1;
                } else {
                    left = midIndex +1;
                }
            } else {
                if (nums[midIndex] <= target && target < nums[right]){
                    left = midIndex +1;

                } else {
                    right = midIndex -1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target: " + search(nums, target)); // Output: 4

        target = 3;
        System.out.println("Index of target: " + search(nums, target)); // Output: -1
    }
}
