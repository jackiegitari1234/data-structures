package com.patterns.problems.cases;


public class MaxProfit {

    public int findMaxProfit(int[] prices) {
        int minValue = prices[0];
        int maxAfterMin = 0;
        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
                maxAfterMin = price;
            } else if (price > maxAfterMin) {
                maxAfterMin = price;
            }
        }
        return (maxAfterMin - minValue);

    }

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int[] height = {8, 6, 2, 5, 4, 1, 3, 7};
        System.out.println("Maximum profit: " + solution.findMaxProfit(height)); // Output: 49
    }
}
