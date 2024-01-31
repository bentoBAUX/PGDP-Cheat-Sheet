package Comparator;
import java.util.Comparator;

class Item{
    private int age;
    public Item(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
public class Comparators implements Comparator<Item>  {
    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item1.getAge(), item2.getAge());
    }


}
