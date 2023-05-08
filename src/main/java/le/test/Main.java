package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Stream;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

        System.out.println("Runtime: " + (System.currentTimeMillis() - start));
        System.out.println(solution.isValidSudoku(new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.', '2' },
                { '.', '.', '.', '.', '.', '.', '6', '.', '.' }, { '.', '.', '1', '4', '.', '.', '8', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '3', '.', '.', '.', '.' }, { '5', '.', '8', '6', '.', '.', '.', '.', '.' },
                { '.', '9', '.', '.', '.', '.', '4', '.', '.' }, { '.', '.', '.', '.', '5', '.', '.', '.', '.' } }));
        System.out.println(solution.isValidSudoku(new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
        System.out.println(solution.isValidSudoku(new char[][] { { '9', '.', '.', '6', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '6', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '1', '.', '3', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '8' }, { '.', '.', '.', '.', '.', '8', '.', '.', '.' },
                { '.', '.', '.', '4', '.', '.', '2', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '1' },
                { '6', '.', '.', '.', '1', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } }));

    }

    private static int convertToIntSum(String string) {
        char[] charArray = string.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
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
