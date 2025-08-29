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


    static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }
}
