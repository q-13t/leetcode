package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;

import javax.xml.crypto.OctetStreamData;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int iterable : Algorithms.radixSort(new int[] { 2, 24, 45, 66, 75, 90, 170, 802 })) {
            System.out.print(iterable + ", ");

        }
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int iterable : Algorithms.countingSort(new int[] { 2, 24, 45, 66, 75, 90, 170, 802 })) {
            System.out.print(iterable + ", ");
        }
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
    }

    private static int convertToIntSum(String string) {
        char[] charArray = string.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
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
