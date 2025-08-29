package com.patterns.problems.linkedlist;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);

        myLinkedList.swapPairs();
        myLinkedList.printList();

        List<String> list1 = new ArrayList<>();
        list1.add("Hello");

        List<String> list2 = list1;
        list2.add("World");

        System.out.println(list1); // [Hello, World]

    }
}
