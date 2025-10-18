package com.patterns.problems.recusivebst;

public class BinarySearchTree {
    Node root;

    Node rInsert (Node currentNode, int value){
        if (currentNode == null) return new Node(value);
        if (value < currentNode.value){
            currentNode.left = rInsert( currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = rInsert( currentNode.right, value);
        }
        return currentNode;

    }

    void rInsert (int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return;
        }
         rInsert(root, value);

    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) { return rContains(root, value); }


    class Node{
        int value;
        Node right;
        Node left;
        Node(int value){
            this.value = value;
        }
    }

    Node rDelete (Node currentNode, int value){
        if (currentNode == null) return null;
        if (value < currentNode.value){
            currentNode.left = rDelete( currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = rDelete( currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right==null){
                return null;
            } else if (currentNode.left == null) {
                return currentNode.right;
                
            }else if (currentNode.right == null) {
                return currentNode.left;
            }else {

            }
        }
        return currentNode;

    }

    Node rDelete (int value){
        if (root == null) return null;
        return rDelete(root, value);
    }
    }
