package Ficha4;

public class LinkedQueue<T> implements QueueADT<T> {
    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int size;

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }

        T element = front.getElement();
        front = front.getNext();
        size--;
        return element;
    }
    
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        
        return front.getElement();
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
    public String toString() {
        String result = "" + front.getElement();
        LinearNode<T> current = front.getNext();
        while (current != null) {
            result += ", " + current.getElement();
            current = current.getNext();
        }
        return result;
    }
}
