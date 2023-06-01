package le.test;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.stream.Stream;

import javax.xml.crypto.OctetStreamData;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution.totalCost(new int[] { 17, 12, 10, 2, 7, 2, 11,
                20, 8 }, 3, 4));
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
        System.out.println(solution.totalCost(new int[] { 50, 80, 34, 9, 86, 20, 67,
                94, 65, 82, 40, 79, 74, 92, 84, 37,
                19, 16, 85, 20, 79, 25, 89, 55, 67, 84, 3, 79, 38, 16, 44, 2, 54, 58 }, 7,
                12));
        System.out.println(solution.totalCost(new int[] { 57, 33, 26, 76, 14, 67, 24, 90, 72, 37,
                30 }, 11,
                2));

    }

    static int bigSum(int[] arr) {
        System.out.println(arr.length);
        int maxSum = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length / 2 && j >= arr.length / 2; i++, j--) {
            int sum = arr[i] + arr[j];
            maxSum = maxSum > sum ? maxSum : sum;
        }
        return maxSum;
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
