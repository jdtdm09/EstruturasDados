import Data_Structure.EmptyCollectionException;
import Data_Structure.LinkedQueue;
import Interface.QueueADT;

public class LinkedQueueMain {
    public static void main(String[] args) throws EmptyCollectionException {

        QueueADT<Integer> stack = new LinkedQueue<Integer>();

        stack.enqueue(10);
        stack.enqueue(20);
        stack.enqueue(30);
        stack.enqueue(40);

        System.out.println(stack);
        System.out.println("<------------------------>");

        try {
            stack.dequeue();
            System.out.println(stack);
            System.out.println("<------------------------>");
        } catch (EmptyCollectionException e) {
            System.out.println("Empty Collection");
        }
    }
}
