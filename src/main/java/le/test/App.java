package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.hIndex(new int[] { 0 }) == 0);
        System.out.println(solution.hIndex(new int[] { 3, 0, 6, 1, 5 }) == 3);
        System.out.println(solution.hIndex(new int[] { 1, 3, 1 }) == 1);
        System.out.println(solution.hIndex(new int[] { 0, 1 }) == 1);
        System.out.println(solution.hIndex(new int[] { 15, 9, 4, 1, 130, 85, 24 }) == 5);
        System.out.println(solution.hIndex(generateArrayOfSize(500, 0, 500)));
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
