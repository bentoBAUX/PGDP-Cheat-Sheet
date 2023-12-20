package SimpleStringList;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        StringList stringList = new StringList(new char[]{'H', 'i'});

        System.out.println("------------------");

        System.out.println();

        System.out.println("List Now: " + stringList.toString());

        System.out.println();

        System.out.println("Concatenating: {',',' ','P','e','n','g','u','i','n'}");

        System.out.println();

        stringList.concat(new char[]{',',' ','P','e','n','g','u','i','n'});

        System.out.println("List Now: " + stringList.toString());

        System.out.println();

        System.out.println("Index of 'e': " + stringList.indexOf('e'));
        System.out.println();
        System.out.println("------------------");





    }
}
