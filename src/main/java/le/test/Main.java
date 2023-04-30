package le.test;

import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.candy(new int[] { 1, 0, 2 }));
        System.out.println(solution.candy(new int[] { 1, 2, 2 }));
        System.out.println(solution.candy(new int[] { 1, 3, 2, 2, 1 }));
        System.out.println(solution.candy(new int[] { 1, 2, 87, 87, 87, 2, 1 }));
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
