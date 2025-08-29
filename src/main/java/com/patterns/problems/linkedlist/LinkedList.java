package com.patterns.problems.linkedlist;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length=1;
    }

    public void printList(){
        Node temp = head;
        while (temp != null ){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            this.tail = newNode;
        }
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            if (length == 1) {
                tail = null;
            }
            head = head.next;
            length--;
            return temp;
        }
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        } else {
            Node lastNode = this.tail;
            if (length == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
                this.tail = temp;

            }
            length--;
            return lastNode;
        }
    }

    void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Boolean hasLoop(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public void removeDuplicates(){
        if (head==null) return;
        Node sorted = head;
        Node current = head.next;
        HashSet<Integer> values = new HashSet<>();
        values.add(head.value);
        while (current != null){
            if (!values.contains(current.value)){
                values.add(current.value);
                sorted.next = current;
                sorted = current;
            } else {
                length --;
            }
            current = current.next;
        }
        sorted.next = null;
    }

    public int binaryToDecimal(){
        int totalValue = 0;
        Node temp = head;
        while (temp != null){
            totalValue = totalValue *2 + temp.value;
            temp = temp.next;
        }
        return totalValue;
    }

    public void partitionList2(int x){
        if (head == null) return;
        Node current = head;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        while (current != null){
            if (current.value < x){
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev1.next = dummy2.next;
        prev2.next = null;
        head = dummy1.next;
        dummy1.next = null;
        dummy2.next = null;
    }

    public void reverseBetween(int x, int y){
        if (head == null) return;
        if (y<x) return;
        Node dummy1 = new Node(0);
        dummy1.next = head;
        Node previous = dummy1;
        int inter = y-x;
        for (int i = 0; i < x; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        for (int i = 0; i < inter; i++) {
            Node tobeMoved = current.next;
            current.next = current.next.next;
            tobeMoved.next = previous.next;
            previous.next = tobeMoved;
        }
        head = dummy1.next;


    }

    public void swapPairs() {
        if (head == null) return;
        Node dummy = new Node(0);
        Node prev = new Node(0);
        dummy.next = head;
        Node first = head;
        Node second;
        while (first != null && first.next != null){
            second = first.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            first = first.next;
        }
        head = dummy.next;

    }

    public void getLength(){
        System.out.println("size is "+ this.length);
    }

    public static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
}
