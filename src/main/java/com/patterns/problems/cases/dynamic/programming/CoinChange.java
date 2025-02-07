package com.patterns.problems.cases.dynamic.programming;

import java.util.Arrays;


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // A large value to represent an unreachable state
        int[] minCoinsNeeded = new int[amount + 1]; // minCoinsNeeded[i] represents the minimum coins needed for amount 'i'
        Arrays.fill(minCoinsNeeded, max); // Fill the minCoinsNeeded array with a large value initially
        minCoinsNeeded[0] = 0; // Base case: 0 coins are needed to make amount 0

        // Iterate through each coin denomination
        for (int coin : coins) {
            // For each amount from 'coin' to 'amount', update the minCoinsNeeded array
            for (int i = coin; i <= amount; i++) {
                int ss = minCoinsNeeded[i - coin] + 1;
                int existingValue = minCoinsNeeded[i];
                minCoinsNeeded[i] = Math.min(existingValue, minCoinsNeeded[i - coin] + 1); // Choose the minimum coins required
            }
        }

        // If minCoinsNeeded[amount] is still 'max', it means the amount cannot be formed with given coins
        return minCoinsNeeded[amount] == max ? -1 : minCoinsNeeded[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {2, 5}; // Available coin denominations
        int amount = 10; // Target amount to make
        System.out.println(solution.coinChange(coins, amount)); // Output: 3 (5+5+1)
    }
}


