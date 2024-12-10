package com.patterns.problems.stack_study;

import com.patterns.problems.linkedlist.Linkedlist;

public class Stack {
    private Node top;
    private int height;
    Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }


    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (height==0){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if (height==0){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    void printStack() {
        Node currentNode = this.top;
        while(currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    void printHeight() {
        System.out.println(height);

    }
    void printTop() {
        System.out.println(top.value);

    }

}
