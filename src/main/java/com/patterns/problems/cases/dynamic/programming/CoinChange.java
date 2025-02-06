package com.patterns.problems.cases.dynamic.programming;

import java.util.Arrays;


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // A large value to represent an unreachable state
        int[] dp = new int[amount + 1]; // dp[i] represents the minimum coins needed for amount 'i'
        Arrays.fill(dp, max); // Fill the dp array with a large value initially
        dp[0] = 0; // Base case: 0 coins are needed to make amount 0

        // Iterate through each coin denomination
        for (int coin : coins) {
            // For each amount from 'coin' to 'amount', update the dp array
            for (int i = coin; i <= amount; i++) {
                int ss = dp[i - coin] + 1;
                int existingValue = dp[i];
                dp[i] = Math.min(existingValue, dp[i - coin] + 1); // Choose the minimum coins required
            }
        }

        // If dp[amount] is still 'max', it means the amount cannot be formed with given coins
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {2, 5}; // Available coin denominations
        int amount = 10; // Target amount to make
        System.out.println(solution.coinChange(coins, amount)); // Output: 3 (5+5+1)
    }
}


