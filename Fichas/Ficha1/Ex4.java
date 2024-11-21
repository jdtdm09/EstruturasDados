import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        UnorderedPair<Integer> pair = new UnorderedPair<Integer>(1, 2);
        UnorderedPair<Integer> pair2 = new UnorderedPair<Integer>(2, 3);



        WildCard wildCard = new WildCard();
        Object myObject = new Object();
        String myString;

        List<?> c = new ArrayList<String>();

        ((List<Object>) c).add(myObject);

        //Exemplo para explicar que podemos ter 2 tipos de dados na lista, o wildcard permite ter qualquer/quaisquer tipos de dados
        ((List<String>) c).add("ola");


        wildCard.printCollection(c);

    }
}
