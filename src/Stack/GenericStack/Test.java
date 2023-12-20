package Stack.GenericStack;

public class Test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack so far: " + stack.toString());
        System.out.println("Stack size: " + stack.size());

        System.out.println();

        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());

        System.out.println();

        System.out.println("Stack so far: " + stack.toString());
        System.out.println("Stack size: " + stack.size());
    }
}
