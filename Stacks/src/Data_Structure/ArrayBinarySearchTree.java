package Data_Structure;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Interface.BinarySearchTreeADT;

public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T>

{
    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }

        Comparable<T> tempElement = (Comparable<T>) element;

        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (tempElement.compareTo((tree[currentIndex])) < 0) {
                    // go left
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    // go right
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        size++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        boolean found = false;

        if (isEmpty())
            return result;

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i])) {
                found = true;
                result = tree[i];
                replace(i);
                size--;
            }
        }

        if (!found)
            throw new ElementNotFoundException("element not found in the binary tree");

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++)
            if (tree[i] != null)
                maxIndex = i;

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;

        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        removeElement(targetElement);

        while (contains(targetElement))
            removeElement(targetElement);

    }

    @Override
    public T removeMin() {

        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 1;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= tree.length) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 1;
            } // while
            result = tree[previousIndex];
            replace(previousIndex);
        } // else

        size--;

        return result;
    }

    @Override
    public T removeMax() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 2;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= maxIndex) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 2;
            } // while
            result = tree[previousIndex];
            replace(previousIndex);
        } // else

        size--;

        return result;
    }

    @Override
    public T findMin() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 1 <= maxIndex) && (tree[currentIndex * 2 + 1] != null))
                currentIndex = currentIndex * 2 + 1;
            result = tree[currentIndex];
        }
        return result;
    }

    @Override
    public T findMax() {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 2 <= maxIndex) && (tree[currentIndex * 2 + 2] != null))
                currentIndex = currentIndex * 2 + 2;
            result = tree[currentIndex];
        }
        return result;
    }
}
