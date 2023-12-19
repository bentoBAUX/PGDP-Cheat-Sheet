package Iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableList<T> implements Iterable<T> {

    private Element first;
    private Element last;

    void insert(T value) {
        if (first == null) {
            first = new Element(value);
            last = first;
        } else {
            var n = new Element(value);
            last.setNext(n);
            last = n;
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator(first);
    }

    public class Iterator implements java.util.Iterator<T> {
        private Element element;

        public Iterator(Element e) {
            this.element=e;
        }

        @Override
        public boolean hasNext() {
            return element!=null;
        }

        @Override
        public T next() {
            if(!hasNext())throw new NoSuchElementException();
            var v = element.value;
            element=element.next;
            return v;
        }
    }

    public class Element {
        private T value;
        private Element next;

        Element(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }



}