package com.patterns.problems.cases;

//move zeros to the end while maintaining the order of non-zero elements
public class MoveZeroToEnd {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        while (nonZeroIndex < n) {
            nums[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
