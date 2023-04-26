package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        TreeNode head = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        // TreeNode head = new TreeNode(-2, null, new TreeNode(-3));
        // TreeNode head = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.hasPathSum(head, 22));

    }
}
