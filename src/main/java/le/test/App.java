package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.maxProfit2(new int[] { 7, 1, 5, 3, 6, 4 }) == 7);
        System.out.println(solution.maxProfit2(new int[] { 1, 2, 3, 4, 5 }) == 4);
        System.out.println(solution.maxProfit2(new int[] { 7, 6, 4, 3, 1 }) == 0);

    }

    @SuppressWarnings(value = { "unused" })
    private static int[] generateArrayOfSize(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }
}
