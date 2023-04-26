package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        TreeNode head = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.minDepth(head));

    }
}
