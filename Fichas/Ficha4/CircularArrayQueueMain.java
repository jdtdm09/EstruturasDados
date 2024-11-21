package Ficha4;

public class CircularArrayQueueMain {
    public static void main(String[] args) {
        QueueADT<Integer> queue = new CircularArrayQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);   //*Expandir a Capacidade após o 5 elemento */
        // queue.enqueue(7);
        // queue.enqueue(8);
        // queue.enqueue(9);

        System.out.println(queue);

        System.out.println("--------------------------");
        try {
            System.out.println(queue.dequeue());    //* tira o primeiro */
            System.out.println(queue);
            System.out.println(queue.first());      //* mostra o primeiro */
            System.out.println(queue);              //* mostra todos os dados */
        } catch (EmptyCollectionException e) {
            System.out.println("Queue is empty: " + e.getMessage());
        }
    } 
}
