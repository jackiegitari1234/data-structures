package com.patterns.problems.doublelinkedlist;

public class DoublyLinkedList2 {
    private Node head;
    private Node tail;
    private int length = 0;

    DoublyLinkedList2(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length=1;
    }

    public void append(int value){
       Node newNode = new Node(value);
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        } else {
            Node temp = tail;
            if (length == 1) {
                this.head = null;
                this.tail = null;
            } else {
               tail = tail.prev;
               tail.next = null;
               temp.prev = null;
            }
            length--;
            return temp;
        }
    }

    public static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null ){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getLength(){
        System.out.println("size is "+ this.length);
    }
}
