package SimpleList;

public class Test {
    public static void main(String[] args) {
        SimpleList simpleList=new SimpleList();

        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(5);
        simpleList.add(55);

        System.out.println();

        System.out.println("List Now: "+ simpleList.toString());
        System.out.println("Adding 4 at index 4: " + simpleList.add(3,4));
        System.out.println("List Now: "+ simpleList.toString());
        System.out.println("Removing 55... " );
        simpleList.remove(simpleList.size()-1);
        System.out.println("List Now: "+ simpleList.toString());



    }
}
