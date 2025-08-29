package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Testing {

    public boolean solution(String string) {
        int left = 0;
        int right = string.length()-1;
        while (right > left ){
            if (string.charAt(right) != string.charAt(left)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public boolean solution2(int n) {
        if ( n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 ==0 ) return false;
        for (int x = 5; x *x <= n; x+=6){
            if (n% x == 0 || n % (x+2) ==0){
                return false;
            }
        }
        return true;

    }


    @Test
    public void printOptions(){
        int[] list = new int[]{1,3,4,6,7,8};
        System.out.println("maxProfit : " +solution2(4));
//        System.out.println("maxProfit : " +solution("mum"));
    }
}
