package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0019RemoveNthNodeFromEndOfList implements LcTemplate {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode p1 = dummy, p2 = dummy;
        while (n > 0 && p2.next != null) {
            p2 = p2.next;
            n--;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
}
