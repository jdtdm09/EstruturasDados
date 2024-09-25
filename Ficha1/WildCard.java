import java.util.Collection;

public class WildCard {
    public void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
}
