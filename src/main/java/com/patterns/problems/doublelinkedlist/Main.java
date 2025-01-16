package com.patterns.problems.doublelinkedlist;

import com.patterns.problems.linkedlist.Linkedlist;

public class Main {
    public static void main(String[] args) {
        NthNode myLinkedList = new NthNode();
        myLinkedList.addNode(32);
        myLinkedList.addNode(78);
        myLinkedList.addNode(65);
        myLinkedList.addNode(90);
        myLinkedList.addNode(12);
        myLinkedList.addNode(44);
        myLinkedList.removeNthNode(3);
        myLinkedList.printNode();

    }
}
