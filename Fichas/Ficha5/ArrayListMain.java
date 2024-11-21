package Ficha5;

public class ArrayListMain {
    public static void main(String[] args) throws EmptyCollectionException {
        ArrayOrderedList<Integer> orderedList = new ArrayOrderedList<>();

        orderedList.add(5);
        orderedList.add(3);
        orderedList.add(8);
        orderedList.add(1);

        System.out.println("Lista Ordenada:");
        System.out.println(orderedList);

        orderedList.remove(3);
        System.out.println("Após remover 3:");
        System.out.println(orderedList);

        System.out.println("Primeiro elemento: " + orderedList.first());
        System.out.println("Último elemento: " + orderedList.last());
    }
}
