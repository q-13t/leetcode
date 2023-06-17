package le.test;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import javax.xml.namespace.QName;

import le.test.LeetCode.SnapshotArray;
import le.test.LeetCode.Solution;
import le.test.LeetCode.TreeNode;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();

        // System.out.println(solution.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 },
        // new int[] { 1, 3, 2, 4 }));

        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));

        // System.out.println(solution.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 },
        // new int[] { 4, 3, 1 }));
        // System.out.println(solution.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 },
        // new int[] { 1, 6, 3, 3 }));
        // System.out.println(solution.makeArrayIncreasing(new int[] { 0, 11, 6, 1, 4, 3
        // }, new int[] { 5, 4, 11, 10, 1,
        // 0 }));
        System.out.println(solution.makeArrayIncreasing(new int[] { 5, 16, 19, 2, 1, 12, 7, 14, 5,
                16 }, new int[] { 6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16 }));
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
