package Ficha6;

public class SmackStackMain {
    public static void main(String[] args) throws Ficha3.EmptyCollectionException {
        try {
            SmackStack<Integer> smackStack = new SmackStack<>();
            smackStack.push(1);
            smackStack.push(2);
            smackStack.push(3);

            System.out.println("Stack antes do smack: " + smackStack);
            System.out.println("Elemento removido com smack: " + smackStack.smack());
            System.out.println("Stack depois do smack: " + smackStack);
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
    }
}
