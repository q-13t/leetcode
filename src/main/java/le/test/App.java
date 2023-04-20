package le.test;

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // ListNode first = new ListNode(1, new ListNode(1, new ListNode(4)));
        // ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode result = solution.mergeTwoLists(first, second);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
