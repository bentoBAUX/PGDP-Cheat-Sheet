package SimpleStringList;
public class StringList {
    private StringListElement first;
    public StringList(char[] data){
        concat(data);
    }

    public int length(){
        int i=0;
        for(StringListElement current = first; current!=null; current=current.getNext()){
            i+=current.getData().length;
        }
        return i;
    }

    public void concat(char[] data){
        if(first == null){
            first = new StringListElement(data);
            return;
        }

        StringListElement index = first;
        StringList newString = new StringList(data);

        while(index.getNext()!=null){
            index = index.getNext();
        }

        index.setNext(newString.first);

    }
    @Override
    public String toString(){
        char[] toString = new char[length()];

        StringListElement current = first;
        int index = 0;
        while(current!=null){
            for (int i = 0; i < current.getData().length; i++) {
                toString[index++] = current.getData()[i];
            }
            current=current.getNext();
        }

        return new String(toString);
    }
    public boolean equals(StringList other){
        if(other == null){
            return false;
        }
        if(other.length()!=length()){
            return false;
        }
        StringListElement current = first;
        StringListElement otherCurrent = other.first;
        int counter = 0;
        while(current!=null&&otherCurrent!=null){
            while(counter<current.getData().length && counter<otherCurrent.getData().length){
                if(current.getData()[counter] != otherCurrent.getData()[counter]){
                    return false;
                }
                counter++;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }
        return true;
    }

    public int indexOf(char c){
        StringListElement current = first;
        int index=0;
        while(current!=null){
            for (int i = 0; i < current.getData().length; i++) {
                if(current.getData()[i]==c){
                    return index;
                }
                index++;

            }
            current=current.getNext();
        }
        return -1;
    }

    public int lastIndexOf(char c){
        StringListElement current = first;
        int index=0;
        int holder = -1;
        while(current!=null){
            for (int i = 0; i < current.getData().length; i++) {
                if(current.getData()[i]==c){
                    holder = index;
                }
                index++;
            }
            current=current.getNext();
        }
        return holder;
    }


}
