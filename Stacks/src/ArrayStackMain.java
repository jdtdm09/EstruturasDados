import Data_Structure.ArrayStack;
import Data_Structure.EmptyCollectionException;
import Interface.StackADT;

public class ArrayStackMain {
    public static void main(String[] args) {
        StackADT<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        System.out.println(stack);

        System.out.println("-----------------");
        try {
            System.out.println(stack.pop());    //* tira o último */
            System.out.println(stack);
            System.out.println(stack.peek());   //* mostra o último */
            System.out.println(stack);          //* mostra todos os dados */
        } catch (EmptyCollectionException e) {
            System.out.println("Stack is empty: " + e.getMessage());
        }

    }
}
