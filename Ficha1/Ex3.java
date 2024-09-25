public class Ex3 {
    public static void main(String[] args) {
        UnorderedPair<Integer> pair = new UnorderedPair<Integer>(1, 2);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        UnorderedPair<Integer> pair2 = new UnorderedPair<Integer>(2, 3);
        System.out.println(pair.equals(pair2));
    }
}
