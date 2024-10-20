package Ficha5;

public interface OrderedListADT<T extends Comparable<T>> extends ListADT<T> {

    public void add(T element);
    
}
