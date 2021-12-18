package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0141LinkedListCycle implements LcTemplate {

    @Override
    public void run() {

    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }
}
