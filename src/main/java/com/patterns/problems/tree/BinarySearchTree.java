package com.patterns.problems.tree;

public class BinarySearchTree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }

    public boolean contains(int value){
        Node temp = root;
        if (root == null){
            return false;
        }
        while (temp != null){
            if (value < temp.value){
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean rContains(Node currentNode, int value){
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        }
        else  {
            return rContains(currentNode.right, value);

        }
    }

    public Node insert(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }
        if (value < currentNode.value){
            currentNode.left = insert(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;

    }


        public boolean rContains(int value){
        return rContains(root, value);
    }

    public void rInsert(int value){
        if (root ==null) root = new Node(value);

        rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }
        if(  value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        } else if(  value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);

        }
        return currentNode;

    }

        public boolean insert(int value){
        Node newNode = new Node(value);
        if (root ==null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value){
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

    public boolean find(int value){
        if (root ==null) return false;
        Node temp = root;
        while (temp != null ){
            if ( temp.value < value){
                temp = temp.left;
            } else if (temp.value > value){
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private Integer  minValue(Node currentNode){
        if(currentNode ==null) return null;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
}
