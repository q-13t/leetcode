package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(solution.threeSum(new int[] { 0, 1, 1 }));
        System.out.println(solution.threeSum(new int[] { 0, 0, 0 }));
        System.out.println(solution.threeSum(new int[] { 1, -1, -1, 0 }));
        System.out.println(solution.threeSum(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 }));
        System.out.println(solution.threeSum(new int[] { 0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0 }));
        // List<Integer> first = Arrays.asList(0, 2, 1);
        // List<Integer> second = Arrays.asList(0, 0, 0);
        // System.out.println(first.containsAll(second));
        // System.out.println(second.containsAll(first));

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
