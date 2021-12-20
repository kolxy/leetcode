package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0092ReverseLinkedList2 implements LcTemplate {
    @Override
    public void run() {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode end = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            end = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = end;
        return last;
    }
}
