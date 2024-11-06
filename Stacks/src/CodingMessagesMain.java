import Data_Structure.CircularArrayQueue;
import Interface.QueueADT;

public class CodingMessagesMain {
    public static void main(String[] args) {

        QueueADT<String> message = new CircularArrayQueue<>();
        int k = 5; //constante para a cifra de cesar
        String str = "abcdefghijklmnopqrstuvxyz";
        char[] ch = str.toCharArray();

        System.out.println(ch[k]);


    }
}
