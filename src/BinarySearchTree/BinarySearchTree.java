package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;


public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;
    public BinarySearchTree(){
        this.root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public int size(){
        return root==null? 0: root.size();
    }

    public void insert(T value){
        if(value==null){
            return;
        }

        if(isEmpty()){
            root = new BSTNode<>(value);
        }else{
            root.insert(value);
        }
    }

    public boolean contains(T value){
        if(value == null){
            return false;
        }

        if(isEmpty()){
            return false;
        }else{
            return root.contains(value);
        }
    }

    public List<T> toList(){
        if(isEmpty()){
            return new LinkedList<>();
        }

        return root.toList(Order.IN);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            return root.toString();
        }
    }
}
