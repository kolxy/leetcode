package LeetCode.list;

import LeetCode.LcTemplate;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc0023MergeKSortedLists implements LcTemplate {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode();
        ListNode pointer = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            pointer.next = pq.poll();
            pointer = pointer.next;
            if (pointer.next != null) {
                pq.add(pointer.next);
            }
        }
        return head.next;
    }

    // not the best space complexity
}
