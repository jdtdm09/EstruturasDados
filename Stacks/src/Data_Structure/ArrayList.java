package Data_Structure;

import Interface.ListADT;

import java.util.Iterator;

public abstract class ArrayList<T> implements ListADT<T>, Iterable<T> {

    private final int DEFAULT_CAPACITY = 100;
    private final int NOTFOUND = -1;
    public int rear;
    public T[] list;


    public ArrayList() {
        rear = 0;
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public ArrayList(int initialCapacity) {
        rear = 0;
        list = (T[]) new Object[initialCapacity];
    }


    public void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);
        System.arraycopy(list, 0, larger, 0, list.length);
        list = larger;
    }


    private int find(T target) {
        for (int i = 0; i < rear; i++) {
            if (target.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }


    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        T result = list[0];
        rear--;
        for (int i = 0; i < rear; i++) {
            list[i] = list[i + 1];
        }
        list[rear] = null;
        return result;
    }


    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        rear--;
        T result = list[rear];
        list[rear] = null;
        return result;
    }


    public T remove(T element) {
        int index = find(element);
        if (index == NOTFOUND) {
            throw new ElementNotFoundException("Element not found");
        }
        T result = list[index];
        rear--;
        for (int i = index; i < rear; i++) {
            list[i] = list[i + 1];
        }
        list[rear] = null;
        return result;
    }


    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        return list[0];
    }


    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        }
        return list[rear - 1];
    }


    public boolean contains(T target) {
        return (find(target) != NOTFOUND);
    }


    public boolean isEmpty() {
        return (rear == 0);
    }


    public int size() {
        return rear;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(list, rear);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rear; i++) {
            result.append(list[i].toString()).append("\n");
        }
        return result.toString();
    }
}
