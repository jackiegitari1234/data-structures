package com.patterns.problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

public  class HashMapMethods {
    Boolean itemInCommon(int[] array1, int[] array2){
        HashMap<Integer, Boolean> myMap = new HashMap<>();
        for (Integer item: array1){
            myMap.put(item, true);
        }
        for (Integer item2: array2){
           if (myMap.get(item2) != null){
               return true;
           }
        }
        return false;

    }
}
