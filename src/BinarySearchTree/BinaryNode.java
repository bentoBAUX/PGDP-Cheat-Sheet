package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryNode<T> extends Node<T> {

    public BinaryNode(T value) {
        // TODO
        super(value, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        // TODO
        super(value, left, right);
    }

    public void setLeft(BinaryNode<T> left) {
        setChild(0, left);

    }

    public void setRight(BinaryNode<T> right) {
        setChild(1, right);
    }

    public BinaryNode<T> getLeft() {
        return (BinaryNode<T>) getChild(0);
    }

    public BinaryNode<T> getRight() {
        return (BinaryNode<T>) getChild(1);
    }

    @Override
    public List<T> toList(Order order) {
        List<T> list = new LinkedList<>();
        List<T> leftList = new LinkedList<>();
        List<T> rightList = new LinkedList<>();

        if (getLeft() != null) {
            leftList = getLeft().toList(order);
        }

        if (getRight() != null) {
            rightList = getRight().toList(order);
        }

        switch (order){
            case IN ->{
                list.addAll(leftList);
                list.add(getValue());
                list.addAll(rightList);
            }

            case PRE -> {
                list.add(getValue());
                list.addAll(leftList);
                list.addAll(rightList);
            }

            case POST -> {
                list.addAll(leftList);
                list.addAll(rightList);
                list.add(getValue());
            }
        }
        return list;
    }


    public String toString(Order order) {
        if(isLeaf()){
            return "["+getValue().toString()+"]";
        }

        String left = "-";
        String right = "-";

        if(getLeft() != null){
            left=getLeft().toString(order);
        }
        if (getRight() != null) {
            right = getRight().toString(order);
        }

        switch (order) {
            case IN:
                return "[" + left + ", " + getValue().toString() + ", " + right + "]";
            case POST:
                return "[" + left + ", " + right + ", " + getValue().toString() + "]";
            case PRE:
                return "[" + getValue().toString() + ", " + left + ", " + right + "]";
            default:
                return "SOMETHING WENT WRONG!";
        }
    }

    @Override
    public String toString() {
        return toString(Order.IN);
    }
}
