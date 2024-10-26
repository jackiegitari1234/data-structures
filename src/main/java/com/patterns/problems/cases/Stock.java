package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int[] prices = {1,6,4,3,1,7};
        System.out.println("maxProfit : " +maxProfit(prices));
    }
}
