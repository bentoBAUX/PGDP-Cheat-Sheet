package Stack;

public class StackElement {
    private int value;
    private StackElement next;

    public StackElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }

    public void setNext(StackElement next) {
        this.next = next;
    }
}
