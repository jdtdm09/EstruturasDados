package Data_Structure;

import Interface.QueueADT;

public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int size;


    public LinkedQueue(T element) {
        front = rear = new LinearNode<>(element);
        size = 1;
    }

    public LinkedQueue() {
        rear = front = null;
        size = 0;

    }

    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (this.rear == null) {
            rear = front = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }


        size++;

    }

    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        T element = front.getElement();
        front = front.getNext();
        size--;
        return element;
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty.");
        }
        return front.getElement();
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }

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
