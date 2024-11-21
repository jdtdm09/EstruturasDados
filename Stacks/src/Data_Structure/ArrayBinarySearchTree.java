package Data_Structure;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import Interface.BinarySearchTreeADT;

import java.util.Iterator;

public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {
    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;

    }

    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 0;
        maxIndex = 0;
    }

    @Override
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) expandCapacity();

        Comparable<T> tempelement = (Comparable<T>) element;

        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    // go left
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) maxIndex = currentIndex * 2 + 1;
                    } else currentIndex = currentIndex * 2 + 1;
                } else {
                    // go right
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) maxIndex = currentIndex * 2 + 2;
                    } else currentIndex = currentIndex * 2 + 2;
                }

            }
        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        size++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException, EmptyCollectionException {

        T result = null;
        boolean found = false;

        if (isEmpty()) return result;

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i])) {
                found = true;
                result = tree[i];
                replace(i);
                size--;
            }
        }

        if (!found) throw new ElementNotFoundException("element not found in the binary tree");

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++)
            if (tree[i] != null) maxIndex = i;

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;

        return result;
    }


    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException, EmptyCollectionException {
        removeElement(targetElement);

        while (true) {
            try {
                removeElement(targetElement);
            } catch (ElementNotFoundException e) {
                break;
            }

        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        T result = findMin();
        removeElement(result);
        return result;
    }

    @Override
    public T removeMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 2;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= maxIndex) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 2;
            } //while
            result = tree[previousIndex];
            replace(previousIndex);
        } //else

        size--;

        return result;
    }

    @Override
    public T findMin() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 1 <= maxIndex) && (tree[currentIndex * 2 + 1] != null))
                currentIndex = currentIndex * 2 + 1;
            result = tree[currentIndex];
        }
        return result;
    }

    @Override
    public T findMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 2 <= maxIndex) && (tree[currentIndex * 2 + 2] != null))
                currentIndex = currentIndex * 2 + 2;
            result = tree[currentIndex];
        }
        return result;
    }

    protected void replace(int targetIndex) throws EmptyCollectionException {
        int currentIndex, parentIndex, oldIndex, newIndex;
        ArrayUnorderedList<Integer> oldlist = new ArrayUnorderedList<>();
        ArrayUnorderedList<Integer> newlist = new ArrayUnorderedList<>();
        ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<>();
        Iterator<Integer> oldIt, newIt;

        // Check if the target index is out of bounds or if it's a leaf node
        if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length) || (tree[targetIndex * 2 + 1] == null && tree[targetIndex * 2 + 2] == null)) {
            tree[targetIndex] = null;
            return;
        }

        // If the target node only has a left child
        if (tree[targetIndex * 2 + 1] != null && tree[targetIndex * 2 + 2] == null) {
            // Prepare lists for replacement indices
            populateListsForReplacement(targetIndex * 2 + 1, targetIndex, oldlist, newlist);

            // Do the replacement
            replaceNodes(oldlist, newlist);
        }
        // If the target node only has a right child
        else if (tree[targetIndex * 2 + 1] == null && tree[targetIndex * 2 + 2] != null) {
            // Prepare lists for replacement indices
            populateListsForReplacement(targetIndex * 2 + 2, targetIndex, oldlist, newlist);

            // Do the replacement
            replaceNodes(oldlist, newlist);
        }
        // If the target node has two children
        else {
            // Find the leftmost node in the right subtree to replace target
            currentIndex = targetIndex * 2 + 2;
            while (currentIndex * 2 + 1 < tree.length && tree[currentIndex * 2 + 1] != null) {
                currentIndex = currentIndex * 2 + 1;
            }

            tree[targetIndex] = tree[currentIndex];
            int currentRoot = currentIndex;

            // If this leftmost node has a right child
            if (tree[currentRoot * 2 + 2] != null) {
                populateListsForReplacement(currentRoot * 2 + 2, currentRoot, oldlist, newlist);
                replaceNodes(oldlist, newlist);
            } else {
                tree[currentRoot] = null;
            }
        }
    }

    /**
     * Populates the oldlist and newlist with indices to replace nodes.
     */
    private void populateListsForReplacement(int startNewIndex, int startOldIndex, ArrayUnorderedList<Integer> oldlist, ArrayUnorderedList<Integer> newlist) throws EmptyCollectionException {
        ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<>();
        int currentIndex;

        // Fill newlist
        templist.addToRear(startNewIndex);
        while (!templist.isEmpty()) {
            currentIndex = templist.removeFirst();
            newlist.addToRear(currentIndex);
            if (currentIndex * 2 + 1 < tree.length && tree[currentIndex * 2 + 1] != null) {
                templist.addToRear(currentIndex * 2 + 1);
            }
            if (currentIndex * 2 + 2 < tree.length && tree[currentIndex * 2 + 2] != null) {
                templist.addToRear(currentIndex * 2 + 2);
            }
        }

        // Fill oldlist
        templist.addToRear(startOldIndex);
        while (!templist.isEmpty()) {
            currentIndex = templist.removeFirst();
            oldlist.addToRear(currentIndex);
            if (currentIndex * 2 + 1 < tree.length && tree[currentIndex * 2 + 1] != null) {
                templist.addToRear(currentIndex * 2 + 1);
            }
            if (currentIndex * 2 + 2 < tree.length && tree[currentIndex * 2 + 2] != null) {
                templist.addToRear(currentIndex * 2 + 2);
            }
        }
    }

    /**
     * Replaces nodes at indices in oldlist with nodes at corresponding indices in newlist.
     */
    private void replaceNodes(ArrayUnorderedList<Integer> oldlist, ArrayUnorderedList<Integer> newlist) {
        Iterator<Integer> oldIt = oldlist.iterator();
        Iterator<Integer> newIt = newlist.iterator();

        while (newIt.hasNext()) {
            int oldIndex = oldIt.next();
            int newIndex = newIt.next();
            tree[oldIndex] = tree[newIndex];
            tree[newIndex] = null;
        }
    }

}
