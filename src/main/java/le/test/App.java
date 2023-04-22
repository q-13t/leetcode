package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        // int[] number = { 9, 9, 9, 9, 9 };
        int[] number = { 3, 6, 1, 2 };

        for (int i : solution.plusOne(number)) {
            System.out.print(i + " ");
        }
    }
}
