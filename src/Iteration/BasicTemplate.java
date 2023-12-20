package Iteration;

import java.util.Iterator;

class SomeDataStructure<T> implements Iterable<T> {

    // code for data structure
    public Iterator iterator() {
        return new CustomIterator(this);
    }

    class CustomIterator<T> implements Iterator<T> {

        // constructor
        CustomIterator(SomeDataStructure obj) {
            // initialize cursor
        }

        // Checks if the next element exists
        public boolean hasNext() {
            return true;
        }

        // moves the cursor/iterator to next element
        public T next() {
            return null;
        }

        // Used to remove an element. Implement only if needed
        public void remove() {
            // Default throws UnsupportedOperationException.
        }
    }
}

