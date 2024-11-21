package Ficha9;

public interface BinaryTreeADT<T> {

    public T getRoot();

    public boolean isEmpty();

    public int size();

    public boolean contains (T targetElement);

    public T find (T targetElement);

    public String toString ();

    public Iterable<T> iteratorInOrder();

    public Iterable<T> iteratorPreOrder();

    public Iterable<T> iteratorPostOrder();

    public Iterable<T> iteratorLevelOrder();
}
