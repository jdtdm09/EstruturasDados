package Ficha5;

public class ArrayOrderedList<T extends Comparable<T>> extends ArrayList<T> implements OrderedListADT<T> {

    // private static final int DEFAULT_CAPACITY = 10;
    // protected T[] list;
    // protected int size;

    public ArrayOrderedList() {
        // list = (T[]) new Comparable[DEFAULT_CAPACITY];
        // size = 0;
    }

    @Override
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        int index = 0;
        while (index < size && element.compareTo(list[index]) > 0) {
            index++;
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(" ");
        }
        return sb.toString();
    }
}