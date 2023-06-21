package le.test;

import java.util.Arrays;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import le.test.LeetCode.Solution;
import le.test.LeetCode.TreeNode;
import le.test.LeetCode.SnapshotArray;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();

        // System.out.println(solution.minCost(new int[] { 1, 3, 5, 2 }, new int[] { 2,
        // 3, 1, 14 }));

        // System.out.println(solution.minCost(new int[] { 2, 2, 2, 2, 2 }, new int[] {
        // 4, 2, 8, 1, 3 }));
        System.out.println(solution.minCost(new int[] { 735103, 366367, 132236,
                133334, 808160, 113001, 49051, 735598,
                686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518 },
                new int[] { 724182, 447415, 723725,
                        902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215,
                        790754, 320604, 468575,
                        825614 }));

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
