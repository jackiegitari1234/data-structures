package com.patterns.problems.merge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2){
        int i =0;
        int j =0;
        int index = 0;
        int[] combined = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]){
                combined[index] = array1[i];
                i++;
                index++;
            } else {
                combined[index] = array2[j];
                j++;
                index++;
            }
        }
        while (i < array1.length){
                combined[index] = array1[i];
                i++;
                index++;
            }

        while (j < array2.length){
            combined[index] = array2[j];
            j++;
            index++;
        }
        return combined;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1) return array;
        int midIndex = array.length/2;
        int[] rightArray= mergeSort( Arrays.copyOfRange(array, 0, midIndex));
        int[] leftArray= mergeSort(  Arrays.copyOfRange(array, midIndex, array.length));

        return merge(rightArray, leftArray);

    }

    public static void main(String[] args) {
        int[] array1 = {1,3,7,8};
        int[] array2 = {2,4,5,6};
        int[] combined = mergeSort(new int[]{1, 3, 4, 2, 8});
        System.out.println(Arrays.toString(combined));

    }

}
