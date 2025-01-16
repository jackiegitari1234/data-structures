package com.patterns.problems.doublelinkedlist;

public class NthNode {
    Node head;

    class Node{
        int value;
        Node nextNode;
        Node prevNode;

        Node(int value){
            this.value = value;
        }
    }

    void addNode(int value){
        Node newNode = new Node(value);
        Node current = head;
        if(head == null){
            current = newNode;
            head = newNode;
            return;
        } else {
            while (current.nextNode != null){
                current = current.nextNode;
            }
            current.nextNode = newNode;
            newNode.prevNode=current;
        }

    }

    void printNode(){
        while (head != null) {
            System.out.println(head.value);
            head = head.nextNode;
        }
    }

    void removeNthNode(int n){
        Node fast = head;
        while (fast.nextNode != null){
            fast = fast.nextNode;
        }
        for (int x=1; x< n; x++){
            fast = fast.prevNode;
        }
        Node prev = fast.prevNode;
        Node next = fast.nextNode;
        prev.nextNode = next;
        next.prevNode = prev;
        fast.prevNode = null;
        fast.nextNode = null;
        System.out.println(fast.value);
    }
}
