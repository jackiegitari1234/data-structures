package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

public class BinarySearch {

    public int search(int[] numbers, int target) {
        int l=0;
        int length=numbers.length-1;
        while(l<=length){
            int midIndex = (l+length)/2;
            if(numbers[midIndex]==target){
                return midIndex;
            }
            if(numbers[midIndex]>target){
                length = midIndex-1;
            }else{
                l = midIndex+1;
            }

        }
        return -1;

    }

    @Test
    public void printOptions(){
        int[] list = new int[]{1,3,4,6,7,8};
        System.out.println("maxProfit : " +search(list, 6));
    }
}
