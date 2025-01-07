package com.patterns.problems.merge;

public class Main {
    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(3);
        myLinkedList.append(5);
        myLinkedList.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);
        l2.append(9);
        l2.append(10);

        myLinkedList.merge(l2);

        myLinkedList.printAll();
    }
}
