package Ficha2;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
        }
    }

    public DoublyLinkedList() {
        //* Inicializar head e tail como nós sentinelas
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.next = tail;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = head.next;
        head.next.previous = newNode;
        head.next = newNode;
        newNode.previous = head;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.previous = tail.previous;
        tail.previous.next = newNode;
        tail.previous = newNode;
        newNode.next = tail;
        size++;
    }

    /* public void RemoveLast(){
        tail.previous = tail.previous.previous;
        tail.previous.next = tail;
    } */

    public void Remove(T value) {
        boolean found = false;
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = head.next;
        while (current != null && !found) {
            if (value.equals(current.value)) {
                found = true;
            } else {
                previous = current;
                current = current.next;
                next = current.next.next;
            }
        }

        previous.next = current.next;
        next.previous = current.previous;

        size--;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) { 
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
