package Queue;

public class QueueElement {
    private int value;
    private QueueElement next;

    public QueueElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement next) {
        this.next = next;
    }
}