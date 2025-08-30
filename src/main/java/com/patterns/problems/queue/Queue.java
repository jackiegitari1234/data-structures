package com.patterns.problems.queue;

public class Queue {
    Node first;
    Node last;
    int length;

    Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    void printQueue(){
      if (first == null) return;
      Node temp = first;
      while (temp != null){
          System.out.println(temp.value);
          temp = temp.next;
      }
    }

    void enqueue(int value){
        Node newNode = new Node(value);
        if (first == null){
            first = newNode;
            last = newNode;
            length = 1;
        } else {
            last.next = newNode;
            last = newNode;
            length ++;
        }
    }

    Node dequeue(){
        if (first == null) return null;
        Node temp = first;
        if (length == 1){
            first = null;
            last = null;

        } else {
            first = first.next;
            temp.next = null;
        }
       length--;
       return temp;


    }

    static class Node{
        int value;
        Node next;
        Node(int value){
           this.value = value;
        }
    }
}
