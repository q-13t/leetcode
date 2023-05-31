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
        System.out.println(solution.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
        System.out.println(solution.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
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
