package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0206ReverseLinkedList implements LcTemplate {
    @Override
    public void run() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i <= 5; i++) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        ListNode result = reverseList(head.next);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        if (curr != null) {
            next = curr.next;
        }
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if (curr != null) {
            curr.next = prev;
        }
        return curr;
    }
}
