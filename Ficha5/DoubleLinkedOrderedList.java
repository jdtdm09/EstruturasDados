package Ficha5;

import Ficha5.DoubleLinearNode;

public class DoubleLinkedOrderedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {
    @Override
    public void add(T element) {

        DoubleLinearNode<T> current = head;

        if(current == null){
            DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
            head = tail = newNode;
            size++;
            return;
        }

        while (current != null) {
            if (element.compareTo(current.getElement()) > 0) {
                DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
                if (current == head) {
                    newNode.setNext(current);
                    current.setPrevious(newNode);
                    head = newNode;
                    size++;
                    return;
                }
                if (current == tail) {
                    newNode.setPrevious(current);
                    current.setNext(newNode);
                    tail = newNode;
                    size++;
                    return;
                }

                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                current.getPrevious().setNext(newNode);
                current.setPrevious(newNode);
                size++;
                return;
            }
            current = current.getNext();
        }
    }

    @Override
    public String toString() {
        String result = "DoubleLinkedOrderedList: [";
        DoubleLinearNode<T> current = head;
        while (current!= null) {
            result += current.getElement() + " <=> ";
            current = current.getNext();
        }
        result += "]";
        return result;
    }
}
