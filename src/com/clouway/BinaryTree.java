package com.clouway;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node root;
    public BinaryTree() {
    }

    /**
     * Adds element into tree without recursion
     * @param val int number being added to the tree
     */
    public void add(int val) {
        Node z = new Node(val);
        if (root == null) {
            root = z;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            if (val < x.value) {
                x = x.left;
            } else if (val > x.value) {
                x = x.right;
            } else {
                return;
            }
        }
        if(val < parent.value){
            parent.left = z;
        } else {
            parent.right = z;
        }
    }

    /**
     * Non recursive version of contains
     * @param value value looked for
     * @return true if value is contained in tree
     */
    public boolean contains(int value){
        Node x = root;
        while (x!=null){
            if(value < x.value)
                x = x.left;
            else if(value > x.value)
                x = x.right;
            else return true;
        }
        return false;
    }
    /**
     * Prints every node sorted in ascending order
     * @param node root of the tree
     */
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    /**
     * Prints every node in Pre Order
     * @param node root of the tree
     */
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    /**
     * Prints every node in Post Order
     * @param node node where traverse starts
     */
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    /**
     * Prints every node in level order
     */
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }

    /**
     * Calls different traverse
     * By default calls level order
     * @param order determines which traverse shall be called
     */
    public void printElements(String order){
        switch (order){
            default:traverseLevelOrder();
            break;
            case "in":traverseInOrder(root);
            break;
            case "pre":traversePreOrder(root);
            break;
            case "post":traversePostOrder(root);
            break;
            case "level":traverseLevelOrder();
        }
    }

    class Node {
        int value;
        Node left;
        Node right;

        /**
         * Constructor for Node class containing its value and both children
         * @param value value of node
         */
        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }


}
