package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        System.out.println("Runtime: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
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
