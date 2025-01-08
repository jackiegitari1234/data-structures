package com.patterns.problems.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insert(int[] array){
        for (int x=1; x<array.length; x++){
            int prevIndex = x-1;
            int currentValue = array[x];
            while (prevIndex > -1 && currentValue < array[prevIndex] ){
                array[prevIndex+1] = array[prevIndex];
                array[prevIndex] = currentValue;
                prevIndex--;
            }
        }

    }

    public static void main(String[] arg){
        int[] array = new int[]{9,5,2,8,1,7};
        insert(array);
        System.out.println(Arrays.toString(array));
    }
    }
