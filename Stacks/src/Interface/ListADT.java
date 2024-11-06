package Interface;

import Data_Structure.EmptyCollectionException;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {


    public T removeFirst() throws EmptyCollectionException;

    public T removeLast() throws EmptyCollectionException;

    public T remove (T element);

    public T first() throws EmptyCollectionException;

    public T last() throws EmptyCollectionException;

    public boolean contains(T target);

    public boolean isEmpty();

    public int size();

    @Override
    public Iterator<T> iterator();

    @Override
    public String toString();

}
