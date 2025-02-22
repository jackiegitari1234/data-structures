package com.patterns.problems.cases;


import org.junit.Test;


public class Stock {

    public int maxProfit(int[] prices){
        int profit = 0;
        int buy = prices[0];
        for (int i=1; i<prices.length; i++){
            if(prices[i]< buy){
                buy = prices[i];
            } else if ( prices[i] - buy > profit ) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    @Test
    public void printOptions() {
        int[] prices = {22,6,4,10,1,7,22};
        System.out.println("maxProfit : " +maxProfit(prices));
    }
}
