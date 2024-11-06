package Data_Structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator {

    private int count; // numero de posições na lista
    private int current; // apontador (posição onde está o interador)
    private T[] items;


    //Cria um Iterator

    public ArrayIterator(T[] collection, int size) {
        items = collection;
        count = size;
        current = 0;
    }


    public boolean hasNext() {
        return (current < count);
    }


    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        current++;

        return items[current - 1];
    }
}
