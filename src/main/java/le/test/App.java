package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result = solution.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
