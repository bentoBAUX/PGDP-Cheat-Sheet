package IO;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        Function<Integer, Integer> addTwo = x->x+2; //<Integer, Integer> = Integer parameter & Integer return
        Function<Integer, Integer> multThree = x->x*3; //<Integer, Integer> = Integer parameter & Integer return

        System.out.println("add Two apply" + addTwo.apply(4));
        System.out.println("addTwo and then multThree" + addTwo.andThen(multThree).apply(4));
        System.out.println("addTwo compose multThree" + addTwo.compose(multThree).apply(4)+"\n");

        List<String> students = List.of("Peter","Paul","Marie");
        Consumer<String> swem = s -> System.out.println(s+"!"); //Takes in a parameter of specified type but doesn't return anything

        students.forEach(swem);
        System.out.println();

        Predicate<String> studentTest = student -> student.startsWith("M"); //Takes in a parameter and returns a boolean
        System.out.println(studentTest.test(students.get(1)));
        System.out.println(students.stream().anyMatch(studentTest));

        Supplier<Double> random1000 = () -> Math.random()*1000; //Takes in no parameters but returns a value of specified type
        System.out.println(random1000.get());

    }
}
