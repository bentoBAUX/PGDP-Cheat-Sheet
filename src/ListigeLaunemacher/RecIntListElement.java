package ListigeLaunemacher;

public class RecIntListElement {
    private int value;
    private RecIntListElement next;
    private RecIntListElement prev;

    public RecIntListElement(int value) {
        this(value, null);
    }

    public RecIntListElement(int value, RecIntListElement prev) {
        this.value = value;
        next = null;
        this.prev = prev;
    }

    public RecIntListElement append(int value) {
        if (next != null) {
            return next.append(value);
        } else {
            next = new RecIntListElement(value, this);
            return next;
        }
    }

    public long[] countThresh(int threshold){
        long[] array = new long[3];
        this.countThreshHelper(threshold,array);
        return array;
    }

    public void countThreshHelper(int threshold, long[] counter){
        if(value<threshold){
            counter[0] += value;
        }else if(value>threshold){
            counter[2] += value;
        }else{
            counter[1]+=value;
        }
        if(next!=null){
            next.countThreshHelper(threshold,counter);
        }
    }
    public void kinguinSort(boolean increasing){
        if(next==null){
            return;
        }
        if(increasing&&this.value>next.value||!increasing&&this.value<next.value){
            //remove
            next=next.next;
            if (next != null) {
                next.prev=this;
                kinguinSort(increasing);
            }
        }else{
            next.kinguinSort(increasing);
        }
    }

    public RecIntListElement reverse() {
        return this.reverseHelper(null);
    }

    public RecIntListElement reverseHelper(RecIntListElement prev){
        RecIntListElement nextHolder = this.next;
        this.next = this.prev;
        this.prev=nextHolder;
        if(nextHolder==null) {
            return this;
        }
        return nextHolder.reverseHelper(this);
    }

    public static void zip(RecIntListElement l1, RecIntListElement l2){
        zipHelper(l1,l2,l1.next);
    }

    public static void zipHelper(RecIntListElement first, RecIntListElement second, RecIntListElement third){
        if(second==null){ //if second is empty
            if(third==null){
                return; //nothing to zip
            }
            first.next=third;
            third.prev=first;
            return;
        }
        if (third == null) {
            first.next=second;
            second.prev=first;
            return;
        }
        first.next=second;
        second.prev=first;
        zipHelper(first.next,third,second.next);
    }


    public int get(int idx) {
        if (idx == 0) {
            return value;
        }
        if (next == null) {
            System.out.println("Invalid index: list is to short!");
            return Integer.MIN_VALUE;
        }
        return next.get(idx - 1);
    }

    public int size() {
        if (next == null) {
            return 1;
        }
        return 1 + next.size();
    }

    public boolean insert(int value, int idx) {
        if (idx < 0) {
            System.out.println("Cannot insert at negative index!");
            return false;
        }
        if (idx <= 1) {
            RecIntListElement n = new RecIntListElement(value, this);
            n.next = next;
            if (next != null) {
                next.prev = n;
            }
            next = n;
            if (idx == 0) {
                next.value = this.value;
                this.value = value;
            }
            return true;
        }
        if (next == null) {
            System.out.println("List is to short to insert at given index!");
            return false;
        }
        return next.insert(value, idx - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        RecIntListElement tmp = this;
        do {
            sb.append(tmp.value).append(", ");
            tmp = tmp.next;
        } while (tmp != null);
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    public String toConnectionString() {
        StringBuilder sb = new StringBuilder();
        RecIntListElement tmp = this;
        do {
            if (tmp.prev != null) {
                sb.append("<-");
            }
            sb.append(tmp.value);
            if (tmp.next != null) {
                sb.append("->");
            }
            tmp = tmp.next;
        } while (tmp != null);
        return sb.toString();
    }
}