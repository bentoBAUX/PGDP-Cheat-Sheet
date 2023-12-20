package TaskPool;

public class Test {
    public static void main(String[] args) {
        Task<String> task = new Task<String>("Bob");
        Task<String> task1 = new Task<String>("Sam");
        Task<String> task2 = new Task<String>("Ted");

        System.out.println("ID of Task 1: " + task.getID());
        System.out.println("ID of Task 2: " +task1.getID());
        System.out.println("ID of Task 3: " +task2.getID());

        TaskPool<String> taskPool = new TaskPool<String>();

        taskPool.insert(task);
        taskPool.insert(task1);
        taskPool.insert(task2);

        System.out.println();

        System.out.println("Task Pool: ");
        taskPool.getTaskPool();

    }
}
