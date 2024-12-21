package com.patterns.problems.hashtable;

import java.util.*;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int hash(String key){
        int hash = 0;
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < keyArray.length; i++){
            int ascii = keyArray[i];
            hash = (hash +ascii*23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if(temp.key.equals( key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList();
        for (Node node: dataMap){
            while (node != null){
                allKeys.add(node.key);
                node = node.next;
            }
        }
        return allKeys;
    }

    public boolean itemsInCommon (int[] array1, int[] array2){
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int item: array1){
            map.put(item, true);
        }

        for (int item: array2){
            if (map.get(item) != null){
                return true;
            }
        }
        return false;
    }

    public List<Integer> findDuplicates ( int[] nums){
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> duplicate = new ArrayList<>();
        for (int item: nums){
            if (map.get(item) != null){
                if(!duplicate.contains(item)){
                    duplicate.add(item);
                }
            }
            map.put(item, true);
        }
        return duplicate;
    }

    public static Character firstNonRepeatingChar(String word){
        HashMap<Character, Integer> map = new HashMap<>();
        if(word.length() == 1) return word.toCharArray()[0];
        for (char item: word.toCharArray()){
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        for (char item: word.toCharArray()){
            if(map.get(item) == 1){
                return item;
            }
        }
        return null;

        }

        public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int x= 0; x<nums.length; x++){
            int rem = target - nums[x];
            if(myMap.containsKey(rem)){
                return new int[]{ myMap.get(rem), x};
            }
            myMap.put(nums[x], x);
        }
        return new int[]{};

        }
}
