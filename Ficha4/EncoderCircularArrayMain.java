package Ficha4;

public class EncoderCircularArrayMain {
    public static void main(String[] args) {
        EncoderCircularArray<Character> encoder = new EncoderCircularArray<>();
        
        String message = "novanjghlimurxilv";
        int[] key = {3, 1, 7, 4, 2, 5};

        try {
            encoder.encode(message, key);
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
    }
}
