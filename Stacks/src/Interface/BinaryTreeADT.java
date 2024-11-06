package Interface;

import java.util.Iterator;
import java.util.EmptyStackException;  
import Data_Structure.BinaryTreeNode;
import Data_Structure.EmptyCollectionException;

public interface BinaryTreeADT<T> {

    public T getRoot() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    public boolean contains (T targetElement);

    public T find (T targetElement);

    public String toString (BinaryTreeNode<T> node);

    public Iterator<T> iteratorInOrder();

    public Iterator<T> iteratorPreOrder();

    public Iterator<T> iteratorPostOrder();

    public Iterator<T> iteratorLevelOrder()throws EmptyCollectionException, EmptyStackException;
}
