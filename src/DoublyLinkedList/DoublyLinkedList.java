package DoublyLinkedList;

public class DoublyLinkedList <T>{
    private DoublyLinkedListElement head;
    private DoublyLinkedListElement tail;
    private int size;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public <T> void append(T info){
        DoublyLinkedListElement <T>newElement = new DoublyLinkedListElement<T>(info);
        if(size==0){
            head = newElement;
            tail = newElement;
        }else{
            tail.next = newElement;
            newElement.prev =tail;
            tail = newElement;
        }
        size++;
    }

    public int size(){
        return size;
    }

    private DoublyLinkedListElement getElement(int index){
        if(index<size/2){
            DoublyLinkedListElement temp = head;
            for (int i = 0; i < index; i++, temp= temp.next); //go forward
            return temp;
        }else{
            DoublyLinkedListElement temp = tail;
            for (int i = size-1; i > index; i--, temp = temp.prev); //go backwards
            return temp;
        }
    }

    public T get(int index){
        if (index < 0 || index>=size) {
            System.out.println("Position ist größer als Liste!");
            return null;
        }

        return (T) getElement(index).getInfo();
    }

    public void remove(int index){
        if(index<0||index>=size){
            System.out.println("Position ist größer als Liste!");
        }else{
            DoublyLinkedListElement toRemove = getElement(index);
            if(toRemove.prev!=null){
                toRemove.prev.next=toRemove.next;
            }else{
                head=toRemove.next;
            }
            if(toRemove.next!=null){
                toRemove.next.prev=toRemove.prev;
            }else{
                tail=toRemove.prev;
            }
            size--;
        }
    }

    @Override //WHY
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(getElement(i).getInfo());
            if(getElement(i).next!=null){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void appendList(DoublyLinkedList list){
        if(size!=0){
            this.tail.next = list.head;
        }else{
            head = list.head;
        }

        if(list.size!=0){
            list.head.prev = tail;
            tail = list.tail;
            size+=list.size;
        }
    }

    public boolean isEqual(DoublyLinkedList list){
        boolean equal = false;
        if(list==null){
            return false;
        }
        if(size == 0 && list.size()==0){
            return true;
        }
        if(size==list.size()){
            for (int i = 0; i < size; i++) {
                if(getElement(i).getInfo()!=list.getElement(i).getInfo()){
                    equal = false;
                }else{
                    equal = true;
                }
            }

        }else{
            equal=false;
        }
        return equal;
    }

    /*public int sum(){
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum+=getElement(i).getInfo();
        }
        return sum;
    }*/

    public DoublyLinkedList copy(){
        DoublyLinkedList copyList = new DoublyLinkedList();
        for(DoublyLinkedListElement current=head; current!=null;current=current.next){
            copyList.append(current.getInfo());
        }
        return copyList;
    }


}