import Data_Structure.LinkedList;

;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> Lista = new LinkedList<Integer>();
    
        Lista.addFirst(1);
        Lista.addFirst(2);
        Lista.addFirst(3);
        Lista.addFirst(4);
        Lista.addFirst(5);
        Lista.addFirst(6);
        


        System.out.println("--------------------------------");

        Lista.Remove(1);
        Lista.Remove(3);
        Lista.Remove(6);



    }
}
