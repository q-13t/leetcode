package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5, new TreeNode(1, null, new TreeNode(1)), new TreeNode(4));
        TreeNode tail = new TreeNode(5, new TreeNode(1, null, new TreeNode(3)), new TreeNode(4));
        System.out.println(solution.isSameTree(head, tail));
    }
}
