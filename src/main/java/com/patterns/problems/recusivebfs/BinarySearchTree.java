package com.patterns.problems.recusivebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()){
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        dfsOrderHelper(root, result);
        return result;
    }

    public Boolean isValidBST() {
        ArrayList<Integer> result = new ArrayList<>();
        dfsOrderHelper(root, result);
        for (int x=0; x<result.size()-2; x++){
            if (result.get(x)  > result.get(x+1)){
                return false;
            }
        }
        return true;
    }

    public Integer kthSmallest(int k) {
        ArrayList<Integer> result = new ArrayList<>();
        dfsOrderHelper(root, result);
        if (k > result.size() || k <= 0){
            return null;
        }else {
            return result.get(k-1);
        }
    }

    // Recursive helper method
    private void dfsOrderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        //result.add(node.value); // Visit root preorder
        dfsOrderHelper(node.left, result); // Traverse left
        result.add(node.value); // Visit root inorder
        dfsOrderHelper(node.right, result); // Traverse right
//        result.add(node.value); // Visit root postorder

    }

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

    public static class Node{
        int value;
        Node right;
        Node left;
        Node(int value){
            this.value = value;
        }
    }
}
