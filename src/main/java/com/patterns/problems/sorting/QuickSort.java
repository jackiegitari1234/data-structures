package com.patterns.problems.sorting;

import java.util.Arrays;

public class QuickSort {

    static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for (int x=pivotIndex+1; x<=endIndex; x++){
            if (array[x] < array[pivotIndex]){
                swapIndex++;
                swap(array, x, swapIndex);
            }
        }
        swap(array, swapIndex, pivotIndex);
        return swapIndex;

    }

    static void swap(int[] array, int index1, int index2){
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;

    }

    public static void quickSort(int[] array, int pivotIndex, int endIndex){
        if (pivotIndex < endIndex){
            int pivot = pivot(array, pivotIndex, endIndex);
            quickSort(array, 0, pivot-1);
            quickSort(array, pivot+1, endIndex);
        }

    }

        public static void main(String[] arg){
        int[] array = new int[]{5,3,9,2,8,1,7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
