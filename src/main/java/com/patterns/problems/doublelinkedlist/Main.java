package com.patterns.problems.doublelinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myLinkedList =new DoublyLinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.removeLast();
        myLinkedList.printList();

    }
}
