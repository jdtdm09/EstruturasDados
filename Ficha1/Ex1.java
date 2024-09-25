public class Ex1 {
    public static void main(String[] args) {
        TwoTypePair<String, String> pair = new TwoTypePair("Primeiro","Segundo");
        System.out.println("Primeiro elemento: " + pair.getFirst());
        System.out.println("Segundo elemento: " + pair.getSecond());

        pair.setFirst("Segundo");
        System.out.println(pair);

        TwoTypePair<Integer, Integer> otherPair = new TwoTypePair<>(1, 2);
        System.out.println(pair.equals(otherPair));
    }
}
