package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int [] numbers){
        Map<Integer, Integer> elements = new HashMap<>();
        for (int x=0; x<numbers.length; x++){
            elements.put(numbers[x], elements.getOrDefault(numbers[x], 0)+1);
        }

        for (Map.Entry<Integer, Integer> map: elements.entrySet()){
            if(map.getValue() > numbers.length/2)
                return map.getKey();
            }
        return 0;
    }


    @Test
    public void printOptions(){
        int[] prices = {2,2,1,1,1,2,2};
        System.out.println("majorityElement : " +majorityElement(prices));
    }
}
