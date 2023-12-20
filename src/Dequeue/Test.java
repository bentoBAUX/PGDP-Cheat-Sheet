package Dequeue;

public class Test {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst(4);
        deque.addLast(5);

        System.out.println("Deque Now: "+deque.toString());
        System.out.println();

        System.out.println("Adding 3 to the left end: ");
        deque.addFirst(3);

        System.out.println("Deque Now: "+deque.toString());
        System.out.println();

        System.out.println("Adding 6 to the right end: ");
        deque.addLast(6);
        System.out.println("Deque Now: "+deque.toString());

        System.out.println();

        System.out.println("Deque Now: "+deque.toString());
        System.out.println();

        System.out.println("Adding 2 to the left end: ");
        deque.addFirst(2);

        System.out.println("Deque Now: "+deque.toString());
        System.out.println();

        System.out.println("Adding 7 to the right end: ");
        deque.addLast(7);
        System.out.println("Deque Now: "+deque.toString());

        System.out.println();

        System.out.println("Adding 1 to the left end: ");
        deque.addFirst(1);

        System.out.println("Deque Now: "+deque.toString());
        System.out.println();

        System.out.println("Adding 8 to the right end: ");
        deque.addLast(8);
        System.out.println("Deque Now: "+deque.toString());



    }
}
