package le.test;

public class App {
    public static void main(String[] args) {
        // ListNode head_1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // ListNode head_2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode head_1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        // ListNode head_1 = new ListNode(1);
        ListNode head_2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9)))))));

        ListNode result = Solution.addTwoNumbers(head_1, head_2);

        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);

    }
}
