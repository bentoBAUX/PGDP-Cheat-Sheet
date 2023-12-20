package Stack;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack so far: "+ Arrays.toString(stack.toArray()));
        System.out.println("Stack size: "+stack.size());
        System.out.println();

        System.out.println("Popping: "+ stack.pop());
        System.out.println("Popping: "+ stack.pop());
        System.out.println("Popping: "+ stack.pop());
        System.out.println();

        System.out.println("Stack so far: "+ Arrays.toString(stack.toArray()));
        System.out.println("Stack size: "+stack.size());


    }
}
