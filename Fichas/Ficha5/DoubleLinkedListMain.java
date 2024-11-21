package Ficha5;

public class DoubleLinkedListMain {
    public static void main(String[] args) throws EmptyCollectionException {
        OrderedListADT<Integer> list = new DoubleLinkedOrderedList<>();

        System.out.println("Is Empty: " + list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println("list: " + list);
        System.out.println("Is Empty: " + list.isEmpty());
        System.out.println("Size: " + list.size());

        System.out.println("==============");

        list.removeFirst();
        list.removeLast();
        list.remove(5);

        System.out.println("list: " + list);
        System.out.println("Size: " + list.size());
    }
}
