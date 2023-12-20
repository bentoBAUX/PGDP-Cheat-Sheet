package TaskPool;


import java.util.HashMap;

public class TaskPool<T> {

    private final HashMap<Integer, Task<T>> taskPool;

    protected TaskPool() {
        taskPool = new HashMap<Integer, Task<T>>();
    }

    public Task<T> insert(Task<T> task) {
        if (taskPool.containsValue(task)) {
            return taskPool.get(task.hashCode());
        }
        taskPool.put(task.hashCode(), task);
        return task;
    }


    public void getTaskPool(){
        for (int name: taskPool.keySet()) {
            String key = Integer.toString(name);
            String value = taskPool.get(name).toString();
            System.out.println(key + ", " + value);
        }
    }
}
