package com.patterns.problems.sorting;

import java.util.Arrays;

public class Merge {

    public static int[] merge(int[] array1, int[] array2){
        int[] combinedArray = new int[array1.length+array2.length];
        int x=0;
        int y=0;
        int z=0;
        while (x<array1.length && y<array2.length){
            if (array1[x] < array2[y]){
                combinedArray[z] = array1[x];
                z++;
                x++;
            } else {
                combinedArray[z] = array2[y];
                z++;
                y++;

            }
        }
        while (x<array1.length){
            combinedArray[z] = array1[x];
            z++;
            x++;
        }
        while (y<array2.length){
            combinedArray[z] = array2[y];
            y++;
            z++;
        }
        return combinedArray;
    }

    public static int[] mergeSort(int[] array){
        if (array.length==1) return array;
        int[] left =mergeSort( Arrays.copyOfRange(array,0, array.length/2));
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length/2, array.length));
       return merge(left, right);

    }

        public static void main(String[] arg){
        int[] array = new int[]{9,10,1,11, 8};
        int[] array2 = new int[]{5,8};
        System.out.println(Arrays.toString(mergeSort(array)));
    }


}
