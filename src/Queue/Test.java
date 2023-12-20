package Queue;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println();


        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());
        System.out.println();
        System.out.println("Queue isEmpty: "+queue.isEmpty());


        System.out.println();
        System.out.println("Popping: "+queue.pop());
        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());
        System.out.println();

        System.out.println("Popping: "+queue.pop());

        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());
        System.out.println();

        System.out.println("Popping: "+queue.pop());

        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());
        System.out.println();

        System.out.println("Popping: "+queue.pop());
        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());

        System.out.println();

        System.out.println("Queue Now: " + Arrays.toString(queue.toArray()));
        System.out.println("Queue Size: "+ queue.size());

        System.out.println();
        System.out.println("Queue isEmpty: "+queue.isEmpty());
    }
}
