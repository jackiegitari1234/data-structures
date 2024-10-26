package com.patterns.problems.linkedlist;

public class Main {
    public static void main(String[] args) {
        Linkedlist myLinkedList = new Linkedlist(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);
        System.out.println(myLinkedList.findKthFromEnd(6).value);

    }
}
