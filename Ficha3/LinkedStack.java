package Ficha3;

public class LinkedStack<T> implements StackADT<T> {
    private LinearNode<T> top;
    private int size;
   
    public LinkedStack(T element) {
        top = new LinearNode<>(element);
        size = 1;
    }

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty");
        }
        T element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty");
        }
        return top.getElement();
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
        String result = "" + top.getElement();
        LinearNode<T> current = top.getNext();
        while (current != null) {
            result += ", " + current.getElement();
            current = current.getNext();
        } 
        return result;
    }
}
