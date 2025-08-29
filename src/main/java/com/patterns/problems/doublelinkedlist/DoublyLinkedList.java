package com.patterns.problems.doublelinkedlist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

   void  printList(){
      if (head == null) return;
      Node temp = head;
      while (temp != null){
          System.out.println(temp.value);
          temp = temp.next;
      }
    }

    void prepend(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            length++;
        }
    }

    void append(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        }
    }

    Node removeLast(int value){
        if (head==null) return null;
        Node temp = tail;
        if (length == 1){
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail.prev = null;
        }
        length --;
        return temp;
    }

    void prePend(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            length++;
        }
    }

    Node removeFirst(){
        if (head==null) return null;
        Node temp = head;
        if (length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length --;
        return temp;
    }

    Node get(int index){
        if (index < 0 || index > length-1){
            return null;
        } else {
            if (index < length/2){
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current;
            } else {
                Node current = tail;
                for (int i = length-1; i > index ; i--) {
                    current = tail.prev;
                }
                return current;
            }
        }
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }


    static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }
}
