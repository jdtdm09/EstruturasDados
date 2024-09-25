public class Pair<T extends Comparable> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T firstItem, T secondItem) {
        this.first = firstItem;
        this.second = secondItem;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public String toString() {
        return ("first: " + first.toString() + "\n"
                + "second: " + second.toString());
    }

    public T max() {
        if (first.compareTo(second) >= 0)
            return first;
        else
            return second;
    }
}
