package Data_Structure;

import Interface.QueueADT;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public CircularArrayQueue() {
        front = rear = size = 0;
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            System.out.println("Expandir Capacidade");
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;  //Resto de Rear +1 : pelo tamanho total do array
        size++;
    }

    private void expandCapacity() {
        T[] larger = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < size(); i++) {
            larger[i] = queue[(front + i) % queue.length];
        }
        front = 0;
        rear = size();
        queue = larger;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        T element = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        return queue[front];
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
        String result = "";
        for (int i = 0; i < size(); i++) {
            result += queue[(front + i) % queue.length] + ", ";
        }
        return result;
    }
}