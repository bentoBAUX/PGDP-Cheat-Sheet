package Queue;

public class Queue {
    private QueueElement first;
    private QueueElement last;
    private int size;

    public void push(int number) {
        QueueElement toPush = new QueueElement(number);
        if(first == null){
            first = last = toPush;
        }else{
            last.setNext(toPush);
            last = toPush;
        }
        size++;
    }

    public int pop() {
        int result = first.getValue();
        if(last==first){
            last = null;
        }
        first = first.getNext();
        size--;
        return result;
    }

    public int[] toArray() {
        int[] queueAsArray = new int[size];
        QueueElement current = first;
        for(int i = 0; current != null; current = current.getNext(), i++) {
            queueAsArray[i] = current.getValue();
        }
        return queueAsArray;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
