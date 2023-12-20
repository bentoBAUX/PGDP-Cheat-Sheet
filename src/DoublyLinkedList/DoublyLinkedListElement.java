package DoublyLinkedList;

public class DoublyLinkedListElement<T>{

    private T info;
    public DoublyLinkedListElement next;
    public DoublyLinkedListElement prev;

    public DoublyLinkedListElement(T info){
        this.info = info;

    }

    public T getInfo() {
        return info;
    }
}
