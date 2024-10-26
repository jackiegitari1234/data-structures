package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findIndices(int[] numbers, int target ){
        Map<Integer, Integer> map = new HashMap<>();
        int length = numbers.length;
        for(int x=0; x<length; x++){
            int complement = target-numbers[x];
            if (map.containsKey(complement)){
                return new int[]{x, map.get(complement)};
            }
            map.put(numbers[x], x);
        }
        return new int[]{};

    }

    @Test
    public void printOptions(){
        int[] prices = new int[]{7,5,4,3,1};
        System.out.println("maxProfit : " +findIndices(prices, 12)[0]);
        System.out.println("maxProfit : " +findIndices(prices, 12)[1]);
    }
}
