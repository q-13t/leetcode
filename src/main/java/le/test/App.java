package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String first = "1010";
        String second = "1011";

        System.out.println(solution.addBinary(first, second));
    }
}
