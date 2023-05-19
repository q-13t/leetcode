package le.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
        TreeNode first = TreeNode.buildTree(new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 0, 1, 1, 2, 3, 3, 2 });
        TreeNode second = TreeNode.buildTree(new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 0, 1, 1, 2, 3, 3, 2 });
        System.out.println(solution.leafSimilar(first, second));
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
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
