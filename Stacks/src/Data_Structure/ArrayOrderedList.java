package Data_Structure;

import Interface.OrderedListADT;


public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
        super();
    }

    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }


    @Override
    public void add(T element) {
        if (size() == list.length)
            expandCapacity();

        Comparable<T> temp = (Comparable<T>) element;

        //procura a posição do elemento "temp"
        int index = 0;
        while (index < rear && temp.compareTo(list[index]) > 0) {
            index++;
        }

        //shift
        for (int index2 = rear; index2 > index; index2--) {
            list[index2] = list[index2 - 1];
        }

        //adiciona
        list[index] = element;
        rear++;
    }
}



