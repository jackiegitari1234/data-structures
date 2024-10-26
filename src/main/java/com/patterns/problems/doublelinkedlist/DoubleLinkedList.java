package com.patterns.problems.doublelinkedlist;


public class DoubleLinkedList {
    Node head;
    Node tail;
    int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoubleLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;

    }

    void append(int value){
        Node newNode = new Node(value);
        if (length==0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next=newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        length++;

    }

    Node removeLast(){
        if(length == 0) return null;
        Node temp = tail;
        if (length==1){
            head = null;
            tail=null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;

    }

    void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;

    }

    Node removeFirst(){
        if(length == 0) return null;
        if(length==1){
            tail = null;
            head=null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;

    }

    Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2) {
            for (int x = 0; x < index; x++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int x = length; x > index; x--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value=value;
            return  true;
        }
        return false;
    }

    boolean insert(int index, int value){
        if(index < 0 || index> length){
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
        Node before = get(index-1);
        Node after = before.next;

        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }
}
