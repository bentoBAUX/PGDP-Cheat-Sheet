package Stack.GenericStack;

import java.util.ArrayList;
import java.util.List;

public class Stack <T>{
    private final List<T> stackList;

    public Stack(){
        stackList=new ArrayList<>();
    }
    public void push(T t) {
        stackList.add(t);
    }

    public T pop() {
        if(stackList.isEmpty()){
            return null;
        }
        T t = stackList.get(stackList.size()-1);
        stackList.remove(stackList.size()-1);
        return t;
    }
}
