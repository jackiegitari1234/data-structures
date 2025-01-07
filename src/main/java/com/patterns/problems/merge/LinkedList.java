package com.patterns.problems.merge;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    void merge(LinkedList otherList){
        Node otherHead = otherList.head;
        Node dummyHead = new Node(0);
        Node dummy = dummyHead;
        length = length + otherList.length;
        while (head != null && otherHead !=null) {
            if (head.value < otherHead.value) {
                dummy.next = head;
                head = head.next;

            } else {
                dummy.next = otherHead;
                otherHead = otherHead.next;
            }
            dummy=dummy.next;
        }
            if (head != null){
                dummy.next = head;
            }
            if(otherHead != null){
                dummy.next = otherHead;
                tail = otherList.tail;
            }
            head = dummyHead.next;
    }


}



