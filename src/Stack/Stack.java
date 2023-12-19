package Stack;

public class Stack {
    private StackElement first;
    private StackElement last;
    private int size;

    public void push(int number) {
        StackElement toPush = new StackElement(number);
        if(first==null){
            first = last = toPush;
        }else{
            toPush.setNext(first);
            first=toPush;
        }
        size++;

    }

    public int pop() {
        if(first == null){
            return Integer.MIN_VALUE;
        }
        int result = first.getValue();
        first = first.getNext();
        size--;
        return result;
    }

    public int[] toArray() {
        int[] queueAsArray = new int[size];
        StackElement current = first;
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