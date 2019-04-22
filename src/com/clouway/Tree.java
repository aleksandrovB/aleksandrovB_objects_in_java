package com.clouway;

import com.clouway.CustomExceptions.NoSuchNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Tree<T> {
    private TreeNode<T> root;
    private Map<Integer, TreeNode<T>> nodes = new LinkedHashMap<>();

    /**
     * Constructors
     * First one creates empty tree
     * Second one adds root to the tree
     */
    public Tree() {
    }
    public Tree(int key, T data) {
        root = new TreeNode<>(data);
        nodes.put(key,root);
    }

    /**
     * Changes nodes data
     * @param nodeKey node which data is being changed
     * @param updatedData new data
     * @throws NoSuchNode if there is no node with nodeKey as key
     */
    public void setData(int nodeKey, T updatedData) throws NoSuchNode {
        try {
            nodes.get(nodeKey).setData(updatedData);
        } catch (NullPointerException e){
            throw new NoSuchNode(String.format("There is no node with %d as key!",nodeKey));
        }
    }

    /**
     * Gets data for node with key nodeKey
     * @param nodeKey key for specific node
     * @return nodeKey's data
     * @throws NoSuchNode if there is no node with nodeKey key
     */
    public T getData(int nodeKey) throws NoSuchNode {
        try {
            return nodes.get(nodeKey).getData();
        } catch (NullPointerException e){
            throw new NoSuchNode(String.format("There is no node with %d as key!",nodeKey));
        }
    }

    /**
     * Gets children of nodeKey's node
     * @param nodeKey node which children will be returned
     * @return children of nodeKey's node
     * @throws NoSuchNode if there is no nodeKey in nodes
     */
    public List<TreeNode> getChildren(int nodeKey) throws NoSuchNode {
        try {
            return nodes.get(nodeKey).getChildren();
        } catch (NullPointerException e){
            throw new NoSuchNode(String.format("There is no node with %d as key!",nodeKey));
        }
    }

    /**
     * Adds new node without parent
     * @param key key for this node
     * @param data data for this node
     */
    public void addNode(int key, T data){
        if(root==null){
            root = new TreeNode<>(data);
            nodes.put(key,root);
        } else{
            if(nodes.containsKey(key)){
                nodes.get(key).setData(data);
            } else {
                TreeNode<T> treeNode = new TreeNode<>(data);
                nodes.put(key,treeNode);
                root.addChild(treeNode);
            }
        }
    }

    /**
     * Adds new node with parent if there is root
     * @param key new node's key
     * @param data new node's data
     * @param parentKey key of already existing parent
     * @throws NoSuchNode if there is no node with parentKey
     */
    public void addNodeWithParent(int key, T data, int parentKey) throws NoSuchNode {
        if(root!=null){
            try {
                if (nodes.containsKey(key)) {
                    nodes.get(key).setData(data);
                    nodes.get(parentKey).addChild(nodes.get(key));
                } else {
                    TreeNode<T> treeNode = new TreeNode<>(data);
                    nodes.put(key, treeNode);
                    nodes.get(parentKey).addChild(treeNode);
                }
            }catch (NullPointerException e){
                throw new NoSuchNode(String.format("There is no parent node with %d as key!",parentKey));
            }
        } else {
            throw new NoSuchNode("Cant add new node with parent if there is no root");
        }
    }

    /**
     * Removes data stored for node
     * @param key node being removed
     * @throws NoSuchNode if node does not exist
     */
    public void remove(int key) throws NoSuchNode {
        try {
            nodes.get(key).removeNode();
            nodes.remove(key);
        } catch (NullPointerException e){
            throw new NoSuchNode(String.format("There is no node with %d as key!",key));
        }
    }

    /**
     * Sets children to parent node
     * @param parentKey parent node
     * @param childKeys child or children being added to parent node
     * @throws NoSuchNode if parentKey does not exist
     */
    public void setChildren(int parentKey, int... childKeys) throws NoSuchNode {
        if(nodes.containsKey(parentKey)) {
            for(int child : childKeys){
                try {
                    nodes.get(parentKey).addChild(nodes.get(child));
                } catch (NullPointerException e){
                throw new NoSuchNode(String.format("There is no child node with %s as key!",child));
                }
            }
        } else {
            throw new NoSuchNode(String.format("Parent with key %d does not exist",parentKey));
        }
    }

    /**
     * Prints every node and its key
     */
    public void printTree(){
        for (int key:nodes.keySet()) {
            System.out.print(key+"="+nodes.get(key)+", ");
        }
        System.out.println();
    }

    /**
     * Gets every node and its key
     * @return every node and its key as Map
     */
    public Map<Integer, TreeNode<T>> getAllNodes(){
        return nodes;
    }

    /**
     * Gets tree sorted by keys
     * @return Map of every node sorted
     */
    public Map<Integer, TreeNode<T>> getSortedTree(){
        return new TreeMap<>(nodes);
    }
}
