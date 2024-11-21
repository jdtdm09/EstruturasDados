package Ficha2;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> Lista = new DoublyLinkedList<Integer>();
    
        Lista.addFirst(1);
        Lista.addFirst(2);
        Lista.addFirst(3);
        Lista.addFirst(4);
        Lista.addFirst(5);
        Lista.addFirst(6);
        Lista.addLast(10);

        Lista.print();

        System.out.println("--------------------------------");

        Lista.Remove(1);
        Lista.Remove(3);
        Lista.Remove(6);
        //Lista.RemoveLast();

        Lista.print();
    }
}
