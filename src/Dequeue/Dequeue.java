package Dequeue;

public class Dequeue {
    private Element head;
    private Element tail;
    private int size;

    public Dequeue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(int x) {

        if (head == null) {
            head = new Element(x);
            tail=head;
        } else {
            head = new Element(x, head);
            head.next.prev = head;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int val = getFirst();

        if (size() == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    public int getFirst() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return head.val;
    }

    public void addLast(int x) {

        if (isEmpty()) {
            head  = new Element(x);
            tail = head;
        } else {
            tail = new Element(tail,x);
            tail.prev.next = tail;
        }
        size++;
    }

    public int removeLast() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int val = getLast();
        if (size() == 1) {
            tail = head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    public int getLast() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return tail.val;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Element current = head; current != null; current = current.next) {
            sb.append(current.val).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }


    private class Element {
        Element prev;
        Element next;
        int val;

        Element(int v) {
            val = v;
        }

        Element(int v, Element n) {
            val = v;
            next = n;
        }

        Element(Element p, int v) {
            val = v;
            prev = p;
        }
    }
}
