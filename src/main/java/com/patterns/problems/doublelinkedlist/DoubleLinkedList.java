package com.patterns.problems.doublelinkedlist;


import com.patterns.problems.linkedlist.Linkedlist;

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

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        if (length == 1){
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length --;
        return temp;
    }

    public Node get(int index){
        if(length == 0) return null;
        if (index < 0 || index>= length){
            return null;
        }
        Node currentNode = head;
        if (index < length/2) {
            for (int x = 0; x < index; x++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int x = length-1; x > index; x--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }



    boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value=value;
            return  true;
        }
        return false;
    }

    Node remove(int index){
        if(index < 0 || index> length){
            return null;
        }
        if (index == 0){
           return  removeFirst();
        }
        if(index == length-1){
           return removeLast();
        }
        Node temp = get(index);
        if (temp != null) {
            Node prev = temp.prev;
            Node next = temp.next;
            prev.next = next;
            next.prev = prev;
            temp.prev = null;
            temp.next = null;
            length--;
            return temp;
        } else {
            return null;
        }

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

    public void reverse(){
        Node temp = head;
        Node before = null;
        head = tail;
        tail = temp;
        while (temp != null){
           Node after = temp.next;
           temp.next = before;
           before=temp;
           temp=after;
        }
    }

    Boolean isPalindrome(){
        if(length<=0) return true;
        Node forwardNoew = head;
        Node backwardNode = tail;
        for (int x=0; x<length/2; x++ ){
            if (forwardNoew.value != backwardNode.value){
                return false;
            }
            forwardNoew = forwardNoew.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }
    void swapPairs(){
        if (length <= 1){
            return;
        }
        Node currentNode = head;
        for (int x=2; x<length+1; x++){
            if (x%2 == 0 && currentNode.next != null){
                int currentValue = currentNode.value;
                currentNode.value = currentNode.next.value;
                currentNode.next.value = currentValue;
            }
            currentNode = currentNode.next;

        }
    }
}
