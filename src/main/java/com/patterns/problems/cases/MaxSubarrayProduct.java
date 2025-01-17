package com.patterns.problems.cases;

public class MaxSubarrayProduct {
    public static int maxSubArray(int[] nums) {
        int maxProduct = 0;
        int currentProduct = 0;
        for (int x=0; x<nums.length; x++){
            currentProduct = Math.max(currentProduct * nums[x], nums[x]);
            maxProduct = Math.max(currentProduct, maxProduct);
        }
        return maxProduct;
    }

        public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println("Maximum subarray sum: " + maxSubArray(nums)); // Output: 6
    }
}
