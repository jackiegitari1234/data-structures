package com.patterns.problems.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Linkedlist {
    private Node head;
    private Node tail;
    private int length;

    public Linkedlist(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    void printLinkedList() {
        Node currentNode = this.head;
        while(currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
    void getLength() {
        System.out.println("Length: " + this.length);
    }

    void getHead() {
        System.out.println("Head: "+this.head.value);
    }

    void getTail() {
        System.out.println("Tail: "+this.tail.value);
    }

    void append(int value){
        Node newNode = new Node(value);
        if (length==0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next=newNode;
            this.tail = newNode;
        }
        length++;

    }

    Node removeLast(){
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if (length==0){
            head=null;
            tail=null;
        }
        return temp;

    }
    void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length==0){
            tail = null;
        }
        return temp;

    }

    Node get(int index){
        if( 0 > index || index>= length ){
            return null;
        }
        Node temp = head;
        for(int x=0; x<index; x++){
            temp = temp.next;
        }
        return temp;

    }

    Boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    Boolean insert( int index, int value){
        if( 0 > index || index>= length ){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next= temp.next;
        temp.next = newNode;
        length ++;
        return true;
    }

    Node remove(int index){
        if( 0 > index || index>= length )return null;
        if (index==0) return removeFirst();
        if(index ==length-1) return removeLast();
        Node prevNode = get(index-1);
        Node temp = prevNode.next;
        prevNode.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }
    void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        for(int x=0; x<length; x++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm)
    Node findMiddleNode(){
        Node toEnd = head;
        Node toMiddle = head;
        while(toEnd !=null && toEnd.next != null){
            toMiddle = toMiddle.next;
            toEnd = toEnd.next.next;
        }
        return toMiddle;

    }

    //tortoise and the hare
    Boolean hasLoop(){
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    void partitionList(int x){
        Node currentNode = head;
        Node dummy1 = new Node(1);
        Node prev1 = dummy1;
        Node dummy2 = new Node(1);
        Node prev2 = dummy2;
        if(head == null) return;
        while(currentNode != null){
            if(currentNode.value < x){
                prev1.next = currentNode;
                prev1 = currentNode;
            } else {
                prev2.next = currentNode;
                prev2 = currentNode;
            }
            currentNode = currentNode.next;
            prev2.next = null;
            prev1.next = dummy2.next;
            head = dummy1.next;
        }

    }

    //use hashmap
    void removeDuplicates(){
        if(head==null) return;
        Node current = head.next;
        Node sortedPointer = head;
        Set<Integer> values  = new HashSet<>();
        values.add(head.value);
        while(current != null){
            if (!values.contains(current.value)){
                sortedPointer.next = current;
                sortedPointer = current;
                values.add(current.value);
            } else {
                length --;
            }
            current = current.next;
        }
        sortedPointer.next = null;
    }

    //double the current total then add value
    int binaryToDecimal(){
        int num = 0;
        Node temp = head;
        while(temp != null){
            num = num * 2 + temp.value;
            temp = temp.next;
        }
        return num;

    }

    void reverseBetween(int startIndex, int endIndex){
        Node temp = null;
        tail = temp;
        Node before = null;

        Node dummy1 = new Node(1);
        Node dummy2 = new Node(1);
        Node dummy3 = new Node(1);
        Node movingDummy1 = dummy1;
        Node movingDummy2 = dummy2;
        Node movingDummy3 = dummy3;
        Node current = head;
        int x= 0;
        while (current != null) {
            if(x < startIndex){
                movingDummy1.next = current;
                movingDummy1 = current;

            } else if(x == startIndex){
                movingDummy3 = current;
                temp = current;
                before = temp;

            }else if( x >  startIndex && endIndex <= x){
                temp = current;
                temp.next = before;
                before = temp;

            } else if(x> endIndex){
                movingDummy2.next = current;
                movingDummy2 = current;
            }
            head = dummy1.next;
            movingDummy1.next = temp;
            current = current.next;
            movingDummy3.next = dummy3.next;
            x++;
        }



    }


}