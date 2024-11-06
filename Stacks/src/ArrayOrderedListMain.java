import Data_Structure.ArrayOrderedList;
import Data_Structure.EmptyCollectionException;
import Interface.OrderedListADT;

import java.util.Iterator;

public class ArrayOrderedListMain {
    public static void main(String[] args) throws EmptyCollectionException {

        OrderedListADT<Integer> list = new ArrayOrderedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);

        list.add(15);
        System.out.println(list);

        list.remove(20);
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
    }
}
