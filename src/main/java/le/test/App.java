package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode re_1_1 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode re_1_2 = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, re_1_1, re_1_2);
        // TreeNode re_1_1 = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        // TreeNode re_1_2 = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        // TreeNode root = new TreeNode(1, re_1_1, re_1_2);

        System.out.println(solution.isSymmetric(root));
    }
}
