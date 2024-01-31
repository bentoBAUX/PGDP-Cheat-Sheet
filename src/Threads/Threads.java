package Threads;

import java.util.ArrayList;
import java.util.List;

class Item{
    private String name;
    public Item(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
public class Threads {
    public static void main(String[] args) {
        ThreadMethod threadMethod = new ThreadMethod(); //With Thread class
        threadMethod.start();

        RunnableMethod runnableMethod = new RunnableMethod(); //With Runnable
        Thread threadRunnable = new Thread(runnableMethod);
        threadRunnable.start();

        //Praxisbeispiel
        List<Item> itemList = new ArrayList<Item>();
        System.out.println("We have many items.");
        ThreadMaker.runInBackground(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Item item = new Item("Item: "+i);
                    itemList.add(item);
                }
            }
        });

        System.out.println("Here are all our items: ");
        for(Item item: itemList){
            System.out.println(item.getName());
        }

    }

}
