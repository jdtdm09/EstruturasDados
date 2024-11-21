public T removeElement(T targetElement) throws ElementNotFoundException {
    if (isEmpty()) {
        throw new ElementNotFoundException("binary search tree");
    }

    Comparable<T> tempElement = (Comparable<T>) targetElement;

    int targetIndex = findIndex(tempElement, 0);

    T result = tree[targetIndex];
    replace(targetIndex);
    count--;

    int temp = maxIndex;
    maxIndex = -1;
    for (int i = 0; i <= temp; i++) {
        if (tree[i] != null) {
            maxIndex = i;
        }
    }

    height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;

    return result;
}


/**
 * Removes the node specified for removal and shifts the tree array accordingly.
 *
 * @param targetIndex the node to be removed
 */
protected void replace(int targetIndex) {
    int currentIndex, parentIndex, temp, oldIndex, newIndex;
    ArrayUnorderedList<Integer> oldlist = new ArrayUnorderedList<>();
    ArrayUnorderedList<Integer> newlist = new ArrayUnorderedList<>();
    ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<>();
    Iterator<Integer> oldIt, newIt;

    /**
     * if target node has no children
     */
    if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length)) {
        tree[targetIndex] = null;
    } /**
        * if target node has no children
        */
    else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] == null)) {
        tree[targetIndex] = null;
    } /**
        * if target node only has a left child
        */
    else if ((tree[targetIndex * 2 + 1] != null) && (tree[targetIndex * 2 + 2] == null)) {
        /**
         * fill newlist with indices of nodes that will replace the corresponding indices in oldlist
         */
        currentIndex = targetIndex * 2 + 1;
        templist.addToRear(currentIndex);
        while (!templist.isEmpty()) {
            currentIndex = (templist.removeFirst());
            newlist.addToRear(currentIndex);
            if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                templist.addToRear(currentIndex * 2 + 1);
                templist.addToRear(currentIndex * 2 + 2);
            }
        }

        /**
         * fill oldlist
         */
        currentIndex = targetIndex;
        templist.addToRear(currentIndex);
        while (!templist.isEmpty()) {
            currentIndex = (templist.removeFirst());
            oldlist.addToRear(currentIndex);
            if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                templist.addToRear(currentIndex * 2 + 1);
                templist.addToRear(currentIndex * 2 + 2);
            }
        }

        /**
         * do replacement
         */
        oldIt = oldlist.iterator();
        newIt = newlist.iterator();
        while (newIt.hasNext()) {
            oldIndex = oldIt.next();
            newIndex = newIt.next();
            tree[oldIndex] = tree[newIndex];
            tree[newIndex] = null;
        }
    } /**
        * if target node only has a right child
        */
    else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] != null)) {
        /**
         * fill newlist with indices of nodes that will replace the corresponding indices in oldlist
         */
        currentIndex = targetIndex * 2 + 2;
        templist.addToRear(currentIndex);
        while (!templist.isEmpty()) {
            currentIndex = (templist.removeFirst());
            newlist.addToRear(currentIndex);
            if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                templist.addToRear(currentIndex * 2 + 1);
                templist.addToRear(currentIndex * 2 + 2);
            }
        }

        /**
         * fill oldlist
         */
        currentIndex = targetIndex;
        templist.addToRear(currentIndex);
        while (!templist.isEmpty()) {
            currentIndex = (templist.removeFirst());
            oldlist.addToRear(currentIndex);
            if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                templist.addToRear(currentIndex * 2 + 1);
                templist.addToRear(currentIndex * 2 + 2);
            }
        }

        /**
         * do replacement
         */
        oldIt = oldlist.iterator();
        newIt = newlist.iterator();
        while (newIt.hasNext()) {
            oldIndex = oldIt.next();

            newIndex = newIt.next();
            tree[oldIndex] = tree[newIndex];
            tree[newIndex] = null;
        }
    } /**
        * if target node has two children
        */
    else {
        currentIndex = targetIndex * 2 + 2;

        while (tree[currentIndex * 2 + 1] != null) {
            currentIndex = currentIndex * 2 + 1;
        }

        tree[targetIndex] = tree[currentIndex];

        /**
         * the index of the root of the subtree to be replaced
         */
        int currentRoot = currentIndex;

        /**
         * if currentIndex has a right child
         */
        if (tree[currentRoot * 2 + 2] != null) {
            /**
             * fill newlist with indices of nodes that will replace the corresponding indices in oldlist
             */
            currentIndex = currentRoot * 2 + 2;
            templist.addToRear(currentIndex);
            while (!templist.isEmpty()) {
                currentIndex = (templist.removeFirst());
                newlist.addToRear(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(currentIndex * 2 + 1);
                    templist.addToRear(currentIndex * 2 + 2);
                }
            }

            /**
             * fill oldlist
             */
            currentIndex = currentRoot;
            templist.addToRear(currentIndex);
            while (!templist.isEmpty()) {
                currentIndex = (templist.removeFirst());
                oldlist.addToRear(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(currentIndex * 2 + 1);
                    templist.addToRear(currentIndex * 2 + 2);
                }
            }

            /**
             * do replacement
             */
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();

                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        } else {
            tree[currentRoot] = null;
        }
    }
}