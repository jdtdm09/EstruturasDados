import Data_Structure.ArrayHeap;
import Data_Structure.EmptyCollectionException;

public class ArrayHeapMain {
    public static void main(String[] args) {
        ArrayHeap<Integer> heap = new ArrayHeap<>();

        // Adicionando elementos
        heap.addElement(15);
        heap.addElement(10);
        heap.addElement(20);
        heap.addElement(5);
        heap.addElement(8);

        try {
            // Encontrar o menor elemento
            System.out.println("Menor elemento: " + heap.findMin()); // Deve ser 5

            // Removendo o menor elemento
            System.out.println("Removendo menor elemento: " + heap.removeMin()); // Remove 5
            System.out.println("Novo menor elemento: " + heap.findMin()); // Deve ser 8
        } catch (EmptyCollectionException e) {
            System.out.println("Erro: A heap está vazia.");
        }
    }
}
