package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0025ReverseNodesInKGroup implements LcTemplate {
    @Override
    public void run() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i <= 7; i++) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        ListNode result = reverseKGroup(head.next, 2);

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy, end = head;
        int count = k;
        while(end != null && end.next != null) {
            end = end.next;
            count--;
            if (count == 1) {
                ListNode after = end.next;
                ListNode begin = start.next;
                start.next = reverse(start.next, end);
                start = begin;
                begin.next = after;
                end = after;
                count = k;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        if (start == end) {
            start.next = null;
            return start;
        }
        ListNode last = reverse(start.next, end);
        start.next.next = start;
        start.next = null;
        return last;
    }
}
