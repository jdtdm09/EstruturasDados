package Interface;

import Data_Structure.EmptyCollectionException;

public interface QueueADT<T> {

    public void enqueue(T element);

    public T dequeue() throws EmptyCollectionException, EmptyCollectionException;

    public T first() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    public String toString();
}
