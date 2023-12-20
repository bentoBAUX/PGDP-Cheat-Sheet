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

    public int size(){
        return stackList.size();
    }

    @Override
    public String toString(){

        if(stackList.isEmpty()){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(T s:stackList){
            sb.append(s);
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");
        return sb.toString();
    }
}
