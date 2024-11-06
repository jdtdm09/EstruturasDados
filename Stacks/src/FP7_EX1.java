import Data_Structure.LinkedList;

public class FP7_EX1 {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

       list.printRecursive();
       System.out.println("\n");

       System.out.println(list);


    }
}
