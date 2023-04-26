package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        // TreeNode branchLeft = new TreeNode(9);
        // TreeNode branchRight_1 = new TreeNode(15);
        // TreeNode branchRight_2 = new TreeNode(7);
        // TreeNode branchRight = new TreeNode(20, branchRight_1, branchRight_2);
        // TreeNode root = new TreeNode(3, branchLeft, branchRight);
        // TreeNode root = new TreeNode(1, null, new TreeNode(2));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        System.out.println(solution.maxDepth(root));
    }
}
