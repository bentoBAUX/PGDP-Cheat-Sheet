package Threads.Baumsumme;

import java.util.Optional;

public class SumThread extends Thread {
    private Optional<Integer> sum;

    private Node node;

    private int remainingThreads;

    SumThread leftThread;
    SumThread rightThread;


    public SumThread(Node node, int remainingThreads) {
        // TODO Exercise 2
        this.sum = Optional.empty();
        this.node = node;
        this.remainingThreads = remainingThreads;
    }

    public Optional<Integer> getSum() {
        return sum;
    }

    public void run() {
        // TODO Exercise 5

        startChildThreads();

        int sumLeft = 0;
        int sumRight = 0;

        if(leftThread != null) {
            try {
                leftThread.join();
                sumLeft = leftThread.getSum().orElse(0);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        if(rightThread != null) {
            try {
                rightThread.join();
                sumRight = rightThread.getSum().orElse(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(rightThread == null && leftThread == null || remainingThreads == 0) {
            this.sum = Optional.of(node.sum());
        } else {

            this.sum = Optional.of(node.getValue() + sumLeft + sumRight);
        }




    }

    protected int runHelper(SumThread thread) {
        if(thread != null) {
            try {
                thread.join();
                return thread.getSum().orElse(0);
            } catch (Exception e) {
                return 0;
            }
        }

        return 0;
    }



    protected void startChildThreads() {

        // TODO Exercise 4

        if(remainingThreads > 2) {
            int rightThreadCount = remainingThreads - leftThreadCount() -1;
            if(node.getRight().isPresent()) {
                rightThread = new SumThread(node.getRight().get(), rightThreadCount);
                rightThread.start();
            }
            if(node.getLeft().isPresent() && leftThreadCount() != 0) {
                leftThread = new SumThread(node.getLeft().get(), leftThreadCount());
                leftThread.start();
                try {
                    leftThread.join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else {
            if(remainingThreads == 2) {
                int rightThreadCount = remainingThreads -1;
                rightThread = new SumThread(node.getRight().get(), rightThreadCount);
                rightThread.start();
            }
        }

    }

    protected int leftThreadCount() {
        // TODO Exercise 3

        if(node.getLeft().isEmpty()) {
            return 0;
        } else if (node.getRight().isEmpty()){
            return remainingThreads-1;
        } else {
            if(remainingThreads % 2 == 0) {
                return (remainingThreads /2) -1;
            } else {
                return (remainingThreads /2);
            }
        }

    }



}
