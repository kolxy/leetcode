package LeetCode.list;

import LeetCode.LcTemplate;

public class Lc0021MergeTwoSortedLists implements LcTemplate {

    @Override
    public void run() {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), pointer = head;
        ListNode pointer1 = list1, pointer2 = list2;
        while (pointer1 != null || pointer2 != null) {
            int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
            if (pointer1 != null) {
                val1 = pointer1.val;
            }
            if (pointer2 != null) {
                val2 = pointer2.val;
            }
            ListNode temp = new ListNode(Math.min(val1, val2));
            pointer.next = temp;
            pointer = pointer.next;
            if (val1 < val2) {
                pointer1 = pointer1.next;
            } else {
                pointer2 = pointer2.next;
            }
        }
        return head.next;
    }

}