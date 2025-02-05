package com.patterns.problems.cases.dynamic.programming;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Stairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(map, n);
    }

    //Fibonacci Optimized, reduce space complexity
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1, second = 2, ways = 0;
        for (int i = 3; i <= n; i++) {
            ways = first + second;
            first = second;
            second = ways;
        }
        return ways;
    }

    public int climbStairs(Map<Integer, Integer> map , int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if(!map.containsKey(n)){
            map.put(n, climbStairs(map, n-1) + climbStairs(map, n-2));
        }
        return map.get(n);

    }

    @Test
    public void printOptions(){
        System.out.println("options : " + climbStairs2(5));
    }
}
