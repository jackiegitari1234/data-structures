package com.patterns.problems.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] array){

        for (int x=0; x< array.length; x++){
            int minIndex = x;
            for (int j=x+1; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != x){
                int temp = array[x];
                array[x] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    public static void selection (int[] array){
        for (int x=0; x<array.length; x++){
            int minIndex = 0;
            for (int j=x+1; j<array.length; j++){
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if (minIndex != x){
                int temp = array[minIndex];
                array[minIndex] = array[x];
                array[x] = temp;
            }
        }

    }

    public static void main(String[] arg){
        int[] array = new int[]{9,5,2,8,1,7};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
