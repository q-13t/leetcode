package le.test;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import le.test.LeetCode.Solution;
import le.test.LeetCode.TreeNode;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        TreeNode root1 = new TreeNode(3);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        System.out.println(solution.distanceK(root1, new TreeNode(5), 2));
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));

        System.out.println(solution.distanceK(new TreeNode(1), new TreeNode(1), 3));
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);
        System.out.println(solution.distanceK(root2, new TreeNode(2), 1));
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(1);
        root3.right.left = new TreeNode(3);

        System.out.println(solution.distanceK(root3, new TreeNode(3), 3));
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
