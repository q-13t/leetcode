package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.removeMultipleDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
        System.out.println(solution.removeMultipleDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
        System.out.println(solution.removeMultipleDuplicates(new int[] { 1, 1, }));
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
