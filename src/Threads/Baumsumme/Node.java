package Threads.Baumsumme;

import java.util.Optional;

class Node {
    private int value;

    // Optional is a wrapper for a value that might be null
    // It is used here to indicate that a node might not have a left or right child
    // Their usage has been explained the lecture on Streams, so take a refresher there if you like.
    // You should know the methods `of`, `isPresent` and `get`.
    private Optional<Node> left;
    private Optional<Node> right;

    public Node(int value) {
        this.value = value;
        this.left = Optional.empty();
        this.right = Optional.empty();
    }

    public void setLeft(Node left) {
        this.left = Optional.of(left);
    }

    public void setRight(Node right) {
        this.right = Optional.of(right);
    }

    public Optional<Node> getLeft() {
        return left;
    }

    public Optional<Node> getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    // You can use this method to test your parallel implementation
    // You will also need it when you want to stop creating
    // further threads.
    public int sum() {
        return this.getValue() + (left.isPresent()? left.get().sum():0) + (right.isPresent()?right.get().sum():0);
    }

    public int sumWithThreads(int numberOfThreads) {
        SumThread sumThread = new SumThread(this, numberOfThreads);
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted:");
            e.printStackTrace();
        }
        // We should never have Optional.empty() after sumThread.join()
        return sumThread.getSum().get();
    }

}
