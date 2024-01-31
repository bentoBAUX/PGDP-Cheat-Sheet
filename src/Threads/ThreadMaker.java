package Threads;

public class ThreadMaker {
    public static void runInBackground(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.start();
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
