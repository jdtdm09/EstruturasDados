package Ficha6;

import Ficha3.ArrayStack;

public class SmackStack<T> extends ArrayStack<T> {

    public SmackStack() {
        super();
    }

    public T smack() throws EmptyCollectionException, Ficha3.EmptyCollectionException{
        if (isEmpty())
            throw new EmptyCollectionException("Stack");

        T lastElement = super.pop();
        return lastElement;
    }
}
