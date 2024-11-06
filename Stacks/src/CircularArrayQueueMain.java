import Data_Structure.CircularArrayQueue;
import Data_Structure.EmptyCollectionException;
import Interface.QueueADT;

public class CircularArrayQueueMain {
    public static void main(String[] args) throws EmptyCollectionException {
        QueueADT<Integer> stack = new CircularArrayQueue<>();

        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);
        stack.enqueue(4);
        stack.enqueue(5);

        System.out.println(stack);

        stack.dequeue();
        System.out.println(stack);
        stack.enqueue(6);
        System.out.println(stack);
        stack.dequeue();
        stack.dequeue();
        System.out.println(stack);
        stack.enqueue(7);
        System.out.println(stack);
        stack.enqueue(8);
        stack.enqueue(9);
        stack.enqueue(10);
        stack.enqueue(11);
        stack.dequeue();
        System.out.println(stack);

    }
}
