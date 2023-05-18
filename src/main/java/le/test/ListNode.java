package le.test;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode copy = this;
        System.out.print("ListNode [");
        while (copy != null) {
            System.out.print(copy.val + ", ");
            copy = copy.next;
        }
        System.out.print("]\n");
    }
}