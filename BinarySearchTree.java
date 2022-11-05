/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author apple
 */
public class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root = null;
    }    
    
    public void traverseInOrder(Node focus) {
        if(focus.left != null) {
            traverseInOrder(focus.left);
        }
        System.out.println(focus.data);
        if(focus.right != null) {
            traverseInOrder(focus.right);
        }
    }
    public void traversePreOrder(Node focus) {
        System.err.println(focus.data);
        if(focus.left != null) {
            traversePreOrder(focus.left);
        }
        if(focus.right != null) {
            traversePreOrder(focus.right);
        }
    }
    public void traversePostOrder(Node focus) {
        if(focus.left != null) {
            traversePostOrder(focus.left);
        }
        if(focus.right != null) {
            traversePostOrder(focus.right);
        }
        System.out.println(focus.data);
    }
    public int minSearchRec(Node focus) {
        if(focus.left != null) {
            return minSearchRec(focus.left);
        }
        return (focus.data);
    }
    public Node searchRec(Node focus,int value) {
        if(focus == null) {
            return null;
        }
        if(focus.data == value) {
            return focus;
        }
        else if(focus.data < value) {
            return searchRec(focus.right, value);
        }else {
            return searchRec(focus.left, value);
        }
    }
    public Node addNodeRec(Node focus,int value) {
        Node newnode = new Node(value);
        if(focus == null) {
            focus = newnode;
            return focus;
        }
        if(focus.data < value) {
            focus.right = addNodeRec(focus.right,value);
        }
        else if(focus.data > value) {
            focus.left = addNodeRec(focus.left,value);
        }
        return focus;
    }
    public void addNode(Node focus,int value) {
        Node newNode = new Node(value);
        if(focus == null) {
            root = newNode;
        }
        Node temp = root;
        Node parent = root;
        while(temp != null) {
            parent = temp;
            if(temp.data < value) {
                temp = temp.right;
            }
            else if(temp.data > value) {
                temp = temp.left;
            }
        }
        if(parent.data > value) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
    }
    public class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
