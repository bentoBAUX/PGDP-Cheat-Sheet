package DoublyLinkedListRecursive;

public class DoublyLinkedListElement {
    private int info;

    public int getInfo() {
        return info;
    }

    // These attributes are public because the elements are only supposed to be
    // used by the list which keeps the invariants. The list does not expose its
    // elements to the outside
    public DoublyLinkedListElement next;
    public DoublyLinkedListElement prev;

    public DoublyLinkedListElement(int startInfo) {
        info = startInfo;
        next = null;
        prev = null;
    }

    public DoublyLinkedList copy(DoublyLinkedList copySoFar) {
        copySoFar.append(info);
        if(next == null) {
            return copySoFar;
        }
        return next.copy(copySoFar);
    }
}
