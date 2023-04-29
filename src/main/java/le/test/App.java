package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        System.out.println(solution.jump(new int[] { 2, 3, 1, 1, 4 }) == 2);
        System.out.println(solution.jump(new int[] { 2, 3, 0, 1, 4 }) == 2);
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
