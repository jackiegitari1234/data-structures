package com.patterns.problems.stack_study;

public class Stack22 {
    private Node top;
    private int height;

    Stack22(int value){
        Node newNode = new Node(value);
        this.top = newNode;
        height = 1;
    }


    class Node{
        int value;
        Node next;

        Node(int value){
           this.value = value;
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

    String reverseString(String text){
        char[] stringChars = text.toCharArray();
        String reversed = "";
        for(int x=stringChars.length-1; x>=0; x--){
            reversed = reversed.concat(String.valueOf(stringChars[x]));

        }
        return reversed;

    }

    void printHeight() {
        System.out.println(height);

    }
    void printTop() {
        System.out.println(top.value);

    }

}
