package Ficha4;

public class EncoderCircularArray<T> {
    private int[] keyArray;
    QueueADT<T> queue = new CircularArrayQueue<>();

    public EncoderCircularArray() {
        
    }

    public void encode(String message, int[] keyArray) throws EmptyCollectionException {
        // Enfileira a mensagem
        for (int i = 0; i < message.length(); i++) {
            queue.enqueue((T) (Character) message.charAt(i)); // Adiciona cada caractere à fila
        }

        int keyIndex = 0;
        // Agora, codifica a mensagem usando a chave
        while (!queue.isEmpty()) {
            T element = queue.dequeue();
            int key = keyArray[keyIndex];
            keyIndex = (keyIndex + 1) % keyArray.length;
            System.out.println("Encoded: " + element + " -> " + key);
        }
    }
}
