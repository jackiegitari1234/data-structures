package com.patterns.problems.stack_study;

public class Queue {
    private Node first;
    private Node last;
    private int length;
    Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }


    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if (length==0){
            first = newNode;
            last = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if (length==0){
            return null;
        }
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }


    void printStack() {
        Node currentNode = this.first;
        while(currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    void printLength() {
        System.out.println(length);

    }
    void printFirst() {
        System.out.println(first);

    }

}