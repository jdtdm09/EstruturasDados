package Ficha5;

import java.util.NoSuchElementException;
import java.util.Iterator;

public abstract class ArrayList<T> implements ListADT<T>, Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    public T[] list;
    public int size;

    public ArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    protected void expandCapacity() {
        T[] larger = (T[]) new Object[list.length * 2];
        System.arraycopy(list, 0, larger, 0, list.length);
        list = larger;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator<T> {

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list[cursor++];
        }
        
        
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }

        T element = list[0];
        for (int i = 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        T element = list[--size];
        list[size] = null;
        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }

        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new EmptyCollectionException("Elemento não encontrado.");
        }
        T result = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1);
        size--;
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        return list[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
