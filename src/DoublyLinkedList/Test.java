package DoublyLinkedList;



public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        doublyLinkedList.append("This");
        doublyLinkedList.append("is");
        doublyLinkedList.append("the");
        doublyLinkedList.append("real");
        doublyLinkedList.append("life");

        System.out.println("List now: "+doublyLinkedList.toString());

        DoublyLinkedList<String> doublyLinkedList1 = new DoublyLinkedList<String>();
        doublyLinkedList1 = doublyLinkedList.copy();

        doublyLinkedList.appendList(doublyLinkedList1);

        System.out.println("List now: "+doublyLinkedList.toString());


    }
}
