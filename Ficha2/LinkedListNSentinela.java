package Ficha2;

public class LinkedListNSentinela<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    class Node<T> {
        T value;
        Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
        }
    }

    public LinkedListNSentinela() {
        //* Inicializar head e tail como nós sentinelas
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.next = tail;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void Remove(T value) {
        boolean found = false;
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !found) {
            if (value.equals(current.value)) {
                found = true;
            } else {
                previous = current;
                current = current.next;
            }
        }

        previous.next = current.next;

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
