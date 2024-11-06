package Data_Structure;

import Interface.BinaryTreeADT;
import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        root = null;
        count = 0;
    }

    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);
    }

    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree, LinkedBinaryTree<T> rightSubtree) {
        root = new BinaryTreeNode<>(element);
        count = 1;
        if (leftSubtree != null) {
            count = count + leftSubtree.size();
            root.left = leftSubtree.root;
        } else {
            root.left = null;
        }

        if (rightSubtree != null) {
            count = count + rightSubtree.size();
            root.right = rightSubtree.root;
        } else {
            root.right = null;
        }
    }

    @Override
    public T getRoot() {
        return root.element; // nao sei se está correto
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T targetElement) {
        boolean found = false;
        try {
            find(targetElement);
            found = true;
        } catch (ElementNotFoundException e) {
            found = false;
        }
        return found;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        if (current == null) {
            throw new ElementNotFoundException("Element not found");
        }
        return current.element;
    }

    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        if (next.element.equals(targetElement)) {
            return next;
        }
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }
        return temp;
    }

    public String toString(BinaryTreeNode<T> targetElement) {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preorder(root, templist);
        return templist.toString();
    } // method toString

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        inorder(root, templist);
        return templist.iterator();
    }

    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
        if (node != null) {
            inorder(node.left, templist);
            templist.addToRear(node.element);
            inorder(node.right, templist);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preorder(root, templist);
        return templist.iterator();
    }

    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
        if (node != null) {
            templist.addToRear(node.element);
            preorder(node.left, templist);
            preorder(node.right, templist);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postorder(root, templist);
        return templist.iterator();
    }

    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
        if (node != null) {
            postorder(node.left, templist);
            postorder(node.right, templist);
            templist.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        BinaryTreeNode<T> current;

        // Adiciona o nó raiz completo à lista de nós
        nodes.addToRear(root);

        while (!nodes.isEmpty()) {
            current = nodes.removeFirst();

            if (current != null) {
                // Adiciona o elemento do nó atual à lista temporária
                templist.addToRear(current.element);

                // Adiciona os filhos esquerdo e direito do nó atual à lista de nós
                if (current.left != null) {
                    nodes.addToRear(current.left);
                }
                if (current.right != null) {
                    nodes.addToRear(current.right);
                }
            }
        }
        return templist.iterator();
    }
}