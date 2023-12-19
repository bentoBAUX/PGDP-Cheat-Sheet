package SimpleStringList;

public class StringListElement {
    private char[] data;
    private StringListElement next;

    public StringListElement(char[] data) {
        this.data = data;
    }

    public char[] getData() {
        return data;
    }

    public StringListElement getNext() {
        return next;
    }

    public void setNext(StringListElement next) {
        this.next = next;
    }
}