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

        // TreeNode root = new TreeNode(4);
        // root.right = new TreeNode(6);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        TreeNode root = new TreeNode(543);
        root.right = new TreeNode(384);
        root.left = new TreeNode(652);
        root.left.right = new TreeNode(445);
        root.right.right = new TreeNode(699);

        System.out.println(solution.getMinimumDifference(root));

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
