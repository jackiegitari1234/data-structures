package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Stairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(map, n);
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
        System.out.println("options : " + climbStairs(190));
    }
}
