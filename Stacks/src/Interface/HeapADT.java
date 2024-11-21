package Interface;

import Data_Structure.EmptyCollectionException;

public interface HeapADT<T> extends BinaryTreeADT<T> {

    public void addElement(T obj);

    public T removeMin() throws EmptyCollectionException;
    
    public T findMin() throws EmptyCollectionException;
    
}
