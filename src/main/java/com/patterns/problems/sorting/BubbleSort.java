package com.patterns.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
//    List<Integer> heap;

    public static void bubble(int[] array){
        for (int x=array.length-1; x>0; x--){
            for (int j=0; j<x; j++){
                if(array[j] > array[j+1] ){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]  = temp;
                }
            }
        }

    }

    public static void bubbleSort(int[] array){
        for (int x=array.length-1; x>0; x--){
            for (int j=0; j<x; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }

    public static void main(String[] arg){
        int[] array = new int[]{9,5,2,8,1,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
