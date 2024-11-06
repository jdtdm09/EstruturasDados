package Data_Structure;

public class LinkedList<T> {
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

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node(value);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
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

        if (previous == null) {
            head = current.next;
        } else { 
            previous.next = current.next;
        }
        size--;

    }

    public void printRecursive(){
        printRecursive(head);
    }

    private void printRecursive(Node<T> node){
        if(node == null){
            return;
        }
        System.out.print(node.value +" ");
       printRecursive(node.next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}

