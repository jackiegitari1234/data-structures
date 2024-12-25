package com.patterns.problems.linkedlist;

public class Main {
    public static void main(String[] args) {
        Linkedlist myLinkedList = new Linkedlist(3);
        myLinkedList.append(3);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.bubbleSort();
        myLinkedList.printLinkedList();

    }
}
