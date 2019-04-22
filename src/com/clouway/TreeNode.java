package com.clouway;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T>{
    private T data;
    private List<TreeNode> children = new ArrayList<>();
    private TreeNode parent = null;

    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * Getters and setters
     */
    public List<TreeNode> getChildren() {return this.children; }
    public T getData() {return data;}
    public TreeNode getParent() {return parent;}
    public void setData(T data) {this.data = data;}
    public void setParent(TreeNode parent) {this.parent = parent;}

    /**
     * Adds child to parent if this child already has parent, old parents children list gets updated
     * @param child new child
     */
    public void addChild(TreeNode child){
        if(child.getParent()!=null)
            child.getParent().children.remove(child);
        if(!this.children.contains(child)) {
            child.setParent(this);
            this.children.add(child);
        }

    }

    /**
     * Removes children for node and removes it from its parents children list
     */
    public void removeNode(){
        this.children.clear();
        this.parent.removeChild(this);
    }

    /**
     * Removes child from children list
     * @param child child being removed
     */
    public void removeChild(TreeNode child){
        this.children.remove(child);
    }

    @Override
    public String toString(){
        return this.data+"";
    }
}
