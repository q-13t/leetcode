package le.test;

//REMEMBER: When passing a zero-length array, Java will create a new array with the exact size of the list. .toArray(new String[0])

import java.util.Random;

import javax.xml.namespace.QName;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(3);
        // TreeNode q = new TreeNode(5);
        // TreeNode p = new TreeNode(1);
        // root.left = q;
        // root.right = p;
        // root.right.left = new TreeNode(0);
        // root.right.right = new TreeNode(8);
        // root.left.left = new TreeNode(6);
        // root.left.right = new TreeNode(2);
        // root.left.left.left = new TreeNode(7);
        // root.left.left.right = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        start = System.currentTimeMillis();
        System.out.println(solution.lowestCommonAncestor(root, root, root.left).val);
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
