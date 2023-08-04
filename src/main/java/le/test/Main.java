package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import org.w3c.dom.ls.LSException;

import le.test.LeetCode.LRUCache;
import le.test.LeetCode.ListNode;
import le.test.LeetCode.Solution;
import le.test.LeetCode.TreeNode;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();

        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));

        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(solution.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
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
