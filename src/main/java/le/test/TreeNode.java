package le.test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    protected static TreeNode buildTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < array.length) {
            TreeNode current = q.remove();
            if (i < array.length) {
                current.left = new TreeNode(array[i++]);
                q.add(current.left);
            }
            if (i < array.length) {
                current.right = new TreeNode(array[i++]);
                q.add(current.right);
            }
        }
        return root;
    }

    public static TreeNode buildBST(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            root = root.insertIntoBST(root, numbers[i]);
        }
        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int number) {
        if (root == null) {
            return new TreeNode(number);
        }
        if (root.val > number) {
            root.right = insertIntoBST(root.right, number);
        } else {
            root.left = insertIntoBST(root.left, number);
        }
        return root;
    }

    public static TreeNode deleteFromBST(TreeNode root, int number) {
        if (root == null)
            return root;

        if (root.val > number)
            root.left = deleteFromBST(root.left, number);
        else if (root.val < number)
            root.right = deleteFromBST(root.right, number);
        else {
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;

            root.val = minTreeValue(root.right);
            root.right = deleteFromBST(root.right, root.val);
        }
        return root;
    }

    private static int minTreeValue(TreeNode node) {
        int minVal = Integer.MIN_VALUE;
        while (node != null) {
            minVal = node.val;
            node = node.left;
        }
        return minVal;
    }

    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ", ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    };

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + ", ");
        printInOrder(node.right);
    };

    public static void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + ", ");
    };

    public static void printLevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + ", ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
