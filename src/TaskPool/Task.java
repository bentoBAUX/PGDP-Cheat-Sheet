package TaskPool;

import java.util.Objects;

public class Task<T> {

    private final int ID;
    private static int IDCounter=0;
    private String name;
    public Task(String name) {
       ID = IDCounter++;
       this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return ID;
    }

    public int getID() {
        return ID;
    }
}
