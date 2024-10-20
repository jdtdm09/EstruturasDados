package Ficha5;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {

    public T removeFirst() throws EmptyCollectionException;

    public T removeLast() throws EmptyCollectionException;

    public T remove(T element) throws EmptyCollectionException;

    public T first() throws EmptyCollectionException;

    public T last() throws EmptyCollectionException;
    
    public boolean isEmpty();

    public int size();

    @Override
    public Iterator<T> iterator();

    @Override
    public String toString();

}
