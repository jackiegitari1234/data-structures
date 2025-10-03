package com.patterns.problems.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMapMethods hashMapMethods = new HashMapMethods();
        int[] array1 = new int[]{1,2};
        int[] array2 = new int[]{3,4};
        System.out.println(hashMapMethods.itemInCommon(array1, array2));
    }
}
