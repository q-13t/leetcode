package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.canJump(new int[] { 2, 3, 1, 1, 4 }) == true);
        System.out.println(solution.canJump(new int[] { 3, 2, 1, 0, 4 }) == false);
        System.out.println(solution.canJump(new int[] { 1, 3, 2 }) == true);

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
