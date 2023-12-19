package Iteration;

import java.awt.*;
import java.util.Iterator;

public class Iterable2DList<T> implements Iterable<T> {
    private IterableList<IterableList<T>> lists;

    public Iterable2DList() {
        lists = new IterableList<>();
    }

    void insert(IterableList<T> value) {
        lists.insert(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new List2DIterator(lists);
    }

    public class List2DIterator implements Iterator<T> {

        private Iterator<IterableList<T>> listIterator;
        private Iterator<T> currentIterator;

        public List2DIterator(IterableList<IterableList<T>> lists) {
            listIterator = lists.iterator();
            while(listIterator.hasNext()){
                currentIterator=listIterator.next().iterator();
                if(currentIterator.hasNext()){
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return currentIterator!=null&&currentIterator.hasNext();
        }

        @Override
        public T next() {
            T current = currentIterator.next();
            while(!currentIterator.hasNext()&&listIterator.hasNext()){
                currentIterator = listIterator.next().iterator();
            }
            return current;
        }
    }

}
