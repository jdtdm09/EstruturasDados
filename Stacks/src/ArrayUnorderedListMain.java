import Data_Structure.ArrayUnorderedList;
import Interface.UnorderedListADT;

public class ArrayUnorderedListMain {
    public static void main(String[] args) {

        UnorderedListADT<Integer> list = new ArrayUnorderedList<>();

        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);
        list.addToRear(40);

        list.addAfter(55,20); //O target é o elemento



        System.out.println(list);


    }
}
