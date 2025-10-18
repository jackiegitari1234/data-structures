package com.patterns.problems.recusivebst;

public class BinarySearchTree {
    Node root;

    boolean insert (int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (value == temp.value) {
                return false;
            }
            if (value < temp.value) {
                if (temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;

            } else {
                if (temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    boolean contains (int value){
        //this line one is not needed
        if (root == null) return false;
        Node temp = root;
        while (temp != null){
            if (temp.value == value){
                return true;
            } else {
                if (value < temp.value){
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        return false;

    }

    class Node{
        int value;
        Node right;
        Node left;
        Node(int value){
            this.value = value;
        }
    }
}
