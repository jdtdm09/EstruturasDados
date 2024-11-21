package Ficha5;

public class DoubleLinearNode<T> {
    private T element;
    private DoubleLinearNode<T> next;
    private DoubleLinearNode<T> previous;

    public DoubleLinearNode() {
        this.element = null;
        this.next = null;
        this.previous = null;
    }

    public DoubleLinearNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public DoubleLinearNode(T element, DoubleLinearNode<T> next, DoubleLinearNode<T> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleLinearNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinearNode<T> next) {
        this.next = next;
    }

    public DoubleLinearNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinearNode<T> previous) {
        this.previous = previous;
    }
}
