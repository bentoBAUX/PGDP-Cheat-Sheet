package Iteration;

import java.util.NoSuchElementException;
import java.util.Objects;


public class IterableTree<T extends Comparable<T>> implements Iterable<T> {
    private Element root;

    public void insert(T value) {
        Objects.requireNonNull(value);
        if (root == null) {
            root = new Element(value);
        } else {
            root.insert(value);
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {

        return new Iterator(root);
    }

    public class Element {
        private T value;
        private Element left;
        private Element right;

        public Element(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getLeft() {
            return left;
        }

        public void setLeft(Element left) {
            this.left = left;
        }

        public Element getRight() {
            return right;
        }

        public void insert(T newValue) {
            if (newValue.compareTo(this.value) <= 0) {
                if (left == null) {
                    left = new Element(newValue);
                } else {
                    left.insert(newValue);
                }
            } else if (newValue.compareTo(this.value) > 0) {
                if (right == null) {
                    right = new Element(newValue);
                } else {
                    right.insert(newValue);
                }
            }
        }

        public void setRight(Element right) {
            this.right = right;
        }
    }

    public class Iterator implements java.util.Iterator<T> {

        private Iterator left = null;
        private Iterator right = null;
        private boolean yieldedOwnValue=false; //ensures that the tree returns the value of the node only once


        private Element element;

        public Iterator(Element e) {
            element=e;
            if(e!=null){
                left = new Iterator(e.left);
                right = new Iterator(e.right);
            }
        }

        @Override
        public boolean hasNext() {
            if (element == null) {
                return false;
            }
            return left.hasNext()|| !yieldedOwnValue || right.hasNext();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            if(left.hasNext()){
                return left.next();
            }else if(!yieldedOwnValue){
                yieldedOwnValue= true;
                return element.value;
            }else{
                return right.next();
            }
        }
    }
}
