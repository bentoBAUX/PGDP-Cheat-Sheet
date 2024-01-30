package Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Item{

}
public class Streams {
    public static void main(String[] args) {

        Item item1 = null;
        Item item2 = null;
        Item item3 = null;

        Stream<Item> stream = Stream.of(item1,item2,item3);

        Item[] itemArray= new Item[3];
        Stream<Item> arrayStream = Arrays.stream(itemArray);

        Collection<Item> itemCollection = null;
        Stream<Item> collectionStream = itemCollection.stream();

        Supplier<Item> itemSupplier = null;
        Stream<Item> supplierStream = Stream.generate(itemSupplier);
        Stream<Integer> supplierStream2 = Stream.generate(()->(new Random()).nextInt(100));

        Iterable<Item> itemIterable = null;
        // Stream<T> java.util.stream.StreamSupport.stream(Spliterator<T> spliterator, boolean parallel)
        Stream<Item> iterableStream = StreamSupport.stream(itemIterable.spliterator(),false);


        Integer[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Non parallel: ");
        Arrays.stream(numbersArray).map(Streams::complexCalculation).forEach(System.out::println); // Non parallel

        System.out.println("\n" + "Parallel: ");
        Arrays.stream(numbersArray).parallel().map(Streams::complexCalculation).forEach(System.out::println); // Parallel

        System.out.println("\n"+"Parallel ordered: ");
        Arrays.stream(numbersArray).parallel().map(Streams::complexCalculation).forEachOrdered(System.out::println); // Parallel ordered



        // Example 1: Creating a Stream from a List
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Grapes", "Mango");

        // Example 2: Filtering elements
        List<String> filteredFruits = fruits.stream().filter(fruit -> fruit.startsWith("A")).collect(Collectors.toList());
        System.out.println("Filtered Fruits: " + filteredFruits);

        // Example 3: Transforming elements
        List<String> uppercasedFruits = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercased Fruits: " + uppercasedFruits);

        // Example 4: Sorting elements
        List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());

        System.out.println("Sorted Fruits: " + sortedFruits);

        // Example 5: Combining operations
        List<String> result = fruits.stream().filter(fruit -> fruit.length() > 5).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println("Result: " + result);

        // Example 6: Reducing elements to a single result
        String concatenatedFruits = fruits.stream().reduce("", (accumulator, fruit) -> accumulator + fruit + ", ");
        System.out.println("Concatenated Fruits: " + concatenatedFruits);

        // Example 7: Checking if any element matches a condition
        boolean anyMatch = fruits.stream().anyMatch(fruit -> fruit.startsWith("B"));
        System.out.println("Any fruit starts with 'B'? " + anyMatch);

        // Example 8: Checking if all elements match a condition
        boolean allMatch = fruits.stream().allMatch(fruit -> fruit.length() > 3);
        System.out.println("All fruits have length greater than 3? " + allMatch);

        // Example 9: Generating a Stream of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Sum of numbers: " + sum+"\n");

        // Example 10: With peek()
        List<String> resultWithPeek = fruits.stream()
                .filter(fruit -> fruit.startsWith("A"))
                .peek(s -> System.out.println("Filtered Fruit: " + s))  // Peek for debugging/logging
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Uppercased Fruit: " + s))  // Peek for debugging/logging
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Final Result: " + resultWithPeek);

        //Example 11: With takeWhile()
        List<Integer> numbersArray2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> resultList = numbersArray2.stream().takeWhile(n -> n <= 5).toList();  // Note: toList() is used to convert the stream back to a List in Java 16+
        System.out.println("Result: " + result);

    }

    public static int complexCalculation(int i){
        try{
            Thread.sleep(300);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        return i*2;
    }


}
