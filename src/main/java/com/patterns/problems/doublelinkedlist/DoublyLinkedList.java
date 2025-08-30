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

    boolean isPalindrome(){
        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i < length/2; i++) {
            if (forwardNode.value != backwardNode.value){
                return false;
            }
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
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

    void reverse(){
        if (head == null) return;
        if (length == 1) return;
        Node current = head;
        while (current != null){
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void partitionList(int x) {
        if (head == null) return;
        if (head.next == null) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node temp1 = dummy1;
        Node temp2 = dummy2;
        Node temp = head;
        while (temp != null){
            if (temp.value < x){
                temp1.next = temp;
                temp.prev = temp1;
                temp1 = temp;
            } else {
                temp2.next = temp;
                temp.prev = temp2;
                temp2 = temp;
            }
            temp = temp.next;
        }
        temp2.next = null;
        temp1.next = dummy2.next;
        if (dummy2.next != null){
            dummy2.next.prev = temp1;
        }
        head = dummy1.next;

        if (head != null) {
            head.prev = null;
        }
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
