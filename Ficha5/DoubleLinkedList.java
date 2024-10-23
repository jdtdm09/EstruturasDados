package Ficha5;

import java.util.Iterator;

public abstract class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {

    protected DoubleLinearNode<T> head;
    protected DoubleLinearNode<T> tail;
    protected int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class DoubleLinkedListIterator<T> implements Iterator<T>  {

        private DoubleLinearNode<T> cursor;
        private int modCount;
        private int expectedModCount;

        public DoubleLinkedListIterator() {
            cursor = (DoubleLinearNode<T>) head;
            }

            public boolean hasNext() {
                return cursor != null; 
            }
            
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new ValueNotFoundException("Empty");  
                }
                T result = cursor.getElement();  
                cursor = cursor.getNext();      
                return result;                    
            }
        }
    

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }
        T element = head.getElement();
        head = head.getNext();
        head.setPrevious(null);

        size--;

        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }
        T element = tail.getElement();
        tail = tail.getPrevious();
        tail.setNext(null);

        size--;

        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        DoubleLinearNode<T> current = head;

        while (current != null && !current.getElement().equals(element)) {
            current = current.getNext();
        }

        if (current == null) {
            throw new EmptyCollectionException("Element not found");
        }

        if (current == head) {
            return removeFirst();
        }

        if (current == tail) {
            return removeLast();
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        size--;

        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }
        return head.getElement(); 
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }
        return tail.getElement(); 
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size; 
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<T>();
    }
}
