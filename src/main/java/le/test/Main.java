package le.test;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import javax.xml.namespace.QName;

import le.test.LeetCode.SnapshotArray;
import le.test.LeetCode.Solution;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        SnapshotArray snapshotArr = new SnapshotArray(3);
        snapshotArr.set(0, 1);
        snapshotArr.set(2, 17);
        snapshotArr.set(0, 19);
        int first = snapshotArr.snap();
        int second = snapshotArr.snap();
        System.out.println(snapshotArr.get(0, first));
        int third = snapshotArr.snap();
        System.out.println(snapshotArr.get(1, second));
        System.out.println(snapshotArr.get(0, third));
        snapshotArr.set(2, 5);
        int fourth = snapshotArr.snap();
        System.out.println(snapshotArr.get(2, fourth));

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
