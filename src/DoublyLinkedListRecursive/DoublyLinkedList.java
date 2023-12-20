package DoublyLinkedListRecursive;

public class DoublyLinkedList {
    private DoublyLinkedListElement head;
    private DoublyLinkedListElement tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void append(int info) {
        DoublyLinkedListElement element = new DoublyLinkedListElement(info);
        if(size == 0) {
            head = tail = element;
        } else {
            tail.next = element;
            element.prev = tail;
            tail = element;
        }

        size++;
    }

    public int size() {
        return size;
    }

    /**
     * Internal getter for a specific list element
     *
     * @param index the position to get, assumed to be valid
     * @return the internal element at the given position
     */
    private DoublyLinkedListElement getElement(int index) {
        if (index < 0 || size <= index) {
            System.out.println("Position ist größer als Liste!");
            return null;
        }
        return getElementHelper(index, 0, head);
    }

    private DoublyLinkedListElement getElementHelper(int index, int counter, DoublyLinkedListElement current){
        if(counter == index){
            return current;
        }

        return getElementHelper(index, counter+1, current.next);

    }

    public int get(int index) {
        if (index < 0 || size <= index) {
            System.out.println("Position ist größer als Liste!");
            return 0;
        }
        return getElement(index).getInfo();
    }

    public void remove(int index) {
        if (size <= index || index < 0) {
            // error if pos is invalid
            System.out.println("Position ist größer als Liste!");
        } else {
            // otherwise link element index-1 with index+1
            DoublyLinkedListElement toRemove = getElement(index);

            // it might delete the head, check if prev exists
            if (toRemove.prev != null) {
                toRemove.prev.next = toRemove.next;
            } else {
                head = toRemove.next;
            }

            // it might be the tail as well, check if next exists
            if (toRemove.next != null) {
                toRemove.next.prev = toRemove.prev;
            } else {
                tail = toRemove.prev;
            }
            size--;
        }
    }

    public void appendList(DoublyLinkedList other) {
        // if this list has elements, append
        if (size != 0) {
            tail.next = other.head;
            // otherwise set new head
        } else {
            head = other.head;
        }
        // if the other list is empty nothing needs to be done
        if (other.size != 0) {
            other.head.prev = tail;
            tail = other.tail;
            size += other.size;
        }
    }

    @Override
    public String toString() {
        if(head == null){
            return "";
        }
        return toStringHelper(this.head);
    }

    public String toStringHelper(DoublyLinkedListElement current){
        String str = Integer.toString(current.getInfo());
        if(current.next!=null){
            return str+ ","+ toStringHelper(current.next)  ;
        }
        return str;
    }



    public boolean isEqual(DoublyLinkedList other) {
        boolean equal = false;
        if (other == null) {
            return false;
        }

        if(head == null) {
            return other.head == null;
        }

        DoublyLinkedListElement otherHead = other.head;
        if(this.size == other.size()){
            return isEqualHelper(this.head,other.head,0);
        }

        return false;

    }

    public boolean isEqualHelper(DoublyLinkedListElement list, DoublyLinkedListElement other, int counter){ //ends when counter == size and returns true then.

        if(counter==size()-1){
            return true;
        }

        if(list.getInfo() != other.getInfo()){
            return false;
        }

        return isEqualHelper(list.next,other.next,counter+1);
    }


    public int sum() {
        if(head==null){
            return 0;
        }
        return sumHelper(this.head);
    }

    public int sumHelper(DoublyLinkedListElement current){
        if(current.next!=null){
            return sumHelper(current.next) + current.getInfo();
        }
        return current.getInfo();
    }

    public DoublyLinkedList copy() {
        DoublyLinkedList copy = new DoublyLinkedList();
        if(head == null) {
            return copy;
        }

        return copyHelper(copy,this.head);
    }

    public DoublyLinkedList copyHelper(DoublyLinkedList list, DoublyLinkedListElement current){
        list.append(current.getInfo());
        if(current.next==null){
            return list;
        }
        return copyHelper(list, current.next);
    }
}
