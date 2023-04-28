package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        solution.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
        solution.rotate(new int[] { -1, -100, 3, 99 }, 2);
        solution.rotate(new int[] { -1 }, 2);
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
