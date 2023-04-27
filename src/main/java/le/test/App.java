package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }) == 5);
        System.out.println(solution.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0);
        System.out.println(solution.maxProfit(new int[] { 2, 4, 1 }) == 2);
        System.out.println(solution.maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2 }) == 2);
        System.out.println(solution.maxProfit(new int[] { 4, 7, 2, 1, 11 }) == 10);
        // System.out.println(solution.maxProfit(generateArrayOfSize((int) Math.pow(10, 5), 0, (int) Math.pow(10, 4))));
    }

    private static int[] generateArrayOfSize(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }
}
