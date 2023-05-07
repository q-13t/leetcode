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

        long start = System.currentTimeMillis();
        System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println("Runtime: " + (System.currentTimeMillis() - start));
        System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 4 }));
        System.out.println(solution.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));

    }

    protected static int[] countingSort(int[] array) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        int[] count = new int[maxVal + 1];
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        for (int i = 1; i <= maxVal; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            output[--count[array[i]]] = array[i];
        }
        return output;
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
