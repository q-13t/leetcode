package le.test;

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

    public static void printNode(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ", ");
        printNode(node.left);
        printNode(node.right);
    };
}
