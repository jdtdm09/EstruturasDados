package Data_Structure;

import java.util.EmptyStackException;
import java.util.Iterator;

import Interface.BinaryTreeADT;
import Interface.QueueADT;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int size;
    protected T[] tree;
    protected final int DEFAULT_CAPACITY = 50;

    public ArrayBinaryTree() {
        size = 0;
        tree = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public ArrayBinaryTree(T element) {
        size = 1;
        tree = (T[])(new Object[DEFAULT_CAPACITY]);
        tree[0] = element;
    }

    @Override
    public T getRoot() throws EmptyCollectionException {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) throws ElementNotFoundException {
        return find(element)!= null;
    }

    protected void expandCapacity() {
        T[] temp = (T[])(new Object[tree.length * 2]);
        for (int i = 0; i < tree.length; i++) {
            temp[i] = tree[i];
        }
        tree = temp;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; ct < size && !found; ct++) {
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        }

        if (!found) {
            throw new ElementNotFoundException("ArrayBinaryTree");
        }

        return temp;
    }

    @Override
    public String toString(BinaryTreeNode<T> root) {
        return "";
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inorder(0, tempList);

        return tempList.iterator();
    }

    protected void inorder(int index, ArrayUnorderedList<T> list) {
        if (index < tree.length) {
            if (tree[index] != null) {
                inorder(index * 2 + 1, list);
                list.addToRear(tree[index]);
                inorder(index * 2 + 2, list);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        preorder(0, tempList);
        return tempList.iterator();
    }

    protected void preorder(int index, ArrayUnorderedList<T> list) {
        if (index < tree.length) {
            if (tree[index] != null) {
                list.addToRear(tree[index]);
                preorder(index * 2 + 1, list);
                preorder(index * 2 + 2, list);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        postorder(0, tempList);
        return tempList.iterator();
    }

    protected void postorder(int index, ArrayUnorderedList<T> list) {
        if (index < tree.length) {
            if (tree[index] != null) {
                postorder(index * 2 + 1, list);
                postorder(index * 2 + 2, list);
                list.addToRear(tree[index]);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException, EmptyStackException {
        if (isEmpty()) {
            throw new EmptyCollectionException("ArrayBinaryTree");
        }

        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        QueueADT<Integer> queue = new LinkedQueue<>();
        queue.enqueue(0);

        while (!queue.isEmpty()) {
            int index = queue.dequeue();
            if (index < tree.length && tree[index] != null) {
                tempList.addToRear(tree[index]);

                if (index * 2 + 1 < tree.length) {
                    queue.enqueue(index * 2 + 1);
                }
                if (index * 2 + 2 < tree.length) {
                    queue.enqueue(index * 2 + 2);
                }
            }
        }

        return tempList.iterator();
    }

}