import Data_Structure.LinkedListNSentinela;

public class LinkedListNSentinelaMain {
    public static void main(String[] args) {
        LinkedListNSentinela<Integer> Lista = new LinkedListNSentinela<Integer>();

        Lista.addFirst(1);
        Lista.addFirst(2);
        Lista.addFirst(3);
        Lista.addFirst(4);
        Lista.addFirst(5);
        Lista.addFirst(6);

        Lista.print();

        System.out.println("--------------------------------");

        Lista.Remove(1);
        Lista.Remove(3);
        Lista.Remove(6);

        Lista.print();
    }
}
