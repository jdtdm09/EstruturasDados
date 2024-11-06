package Data_Structure;


import Interface.UnorderedListADT;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() {
        super();
    }

    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }


    public void addToFront(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        for (int i = rear; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[0] = element;
        rear++;

    }


    public void addToRear(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        list[rear] = element;
        rear++;
    }


    public void addAfter(T element, T target) {
        if (size() == list.length) {
            expandCapacity();
        }
        int i = 0;
        while (i < rear && !target.equals(list[i])) {
            i++;
        }

        if (i == rear) {
            throw new ElementNotFoundException("Element not found");
        }


        for (int j = rear; j > i; j--) {
            list[j] = list[j - 1];
        }
        list[i] = element;
        rear++;

    }
}
