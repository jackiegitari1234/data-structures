package com.patterns.problems.hashtable;

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
        char[] keyChars = key.toCharArray();
        for (int i=0; i<keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue*23) % dataMap.length;
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
}
