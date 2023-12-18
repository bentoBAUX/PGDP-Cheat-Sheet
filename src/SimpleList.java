public class SimpleList {

    private Element head;
    private Element tail;
    private int size;

    SimpleList() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
     * returns size/length of the list
     */
    public int size() {
        return size;
    }

    /*
     * returns <true> if the list is empty, otherwise <false>
     */
    public boolean isEmpty() {
        if(size<=0){
            return true;
        }
        return false;
    }

    /*
     * removes all elements from the list
     */
    public void clear() {
        head=null;	//LOOKED AT MUSTERLOESUNG
        tail=null;
        size=0;
    }

    /*
     * adds an element at the end of the list
     */
    public void add(int element) {
        if(head==null){
            head = new Element(element);
            tail = head;
        }else{
            tail.next = new Element(element);
            tail = tail.next; //LOOKED AT MUSTERLOESUNG
        }
        size++;
    }

    /*
     * adds an element at the specified index
     */
    public boolean add(int index, int element) {
        //LOOKED AT MUSTERLOESUNG
        if(index<0||index>size){
            return false;
        }
        if(head==null){
            head = new Element(element);
            tail = head;
        }else if(index == 0){
            head = new Element(element,head);
        }else if(index == size){
            tail.next = new Element(element);
            tail = tail.next;
        }else{
            Element current = head;
            for (int i = 0; i <index-1 ; i++) { //index - 1 because you insert it before the previous element at that index
                current = current.next; //traversing through the linked list
            }
            current.next = new Element(element,current.next);
        }
        size++;
        return true;
    }

    /*
     * returns the value of the element at the specified index returns default value
     * (minimum value of an integer) iff. such an element does not exist.
     */
    public int get(int index) {
        Element current = head;
        if (index < 0 || size <= index) {
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;

    }

    /*
     * removes the element at the specified index
     */
    public void remove(int index) {
        Element current = head;
        if (index < 0 || size <= index) {
            return;
        }
        if(size ==1){
            head=null;
            tail=null;
        }
        else if(index==0){
            head=head.next;
        }else{
            for (int i = 0; i < index-1; i++) {
                current=current.next;
            }
            current.next=current.next.next;
            if(index == size -1){
                tail = current;
            }
        }

        size--; //DONT FORGET TO READJUST ARRAY
    }

    /*
     * returns String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[ ");
        Element current = head;
        for (int i = 0; i < size; i++) {
            out.append(current.toString());
            if (i != size - 1) {
                out.append(", ");
            }
            current = current.next;
        }
        out.append(" ]");
        return out.toString();
    }

    private static class Element {
        private int value;
        private Element next;

        Element(int value) {
            this.value = value;
            next = null;
        }

        Element(int value, Element next) {
            this.value = value;
            this.next=next;
        }

        /*
         * returns String representation of the element
         */
        @Override
        public String toString() {
            return "" + value;
        }
    }

}