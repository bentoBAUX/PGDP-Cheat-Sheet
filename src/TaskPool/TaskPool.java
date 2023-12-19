package TaskPool;


import java.util.HashMap;

public class TaskPool<T, R> {

    private final HashMap<Integer, Task<T, R>> taskPool;

    protected TaskPool() {
        taskPool = new HashMap<Integer, Task<T, R>>();
    }

    public Task<T, R> insert(Task<T, R> task) {
        if (taskPool.containsValue(task)) {
            return taskPool.get(task.hashCode());
        }
        taskPool.put(task.hashCode(), task);
        return task;
    }

    public Task<T, R> getByValue(T input) {
        Task<T, R> task = new Task<T, R>();
        return task;
    }
}
