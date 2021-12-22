package LeetCode.binarytree;

import LeetCode.LcTemplate;

public class Lc0116PopulatingNextRightPointers implements LcTemplate {
    @Override
    public void run() {

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwo(root.left, root.right);
        return root;
    }

    public void connectTwo(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectTwo(left.left, left.right);
        connectTwo(right.left, right.right);
        connectTwo(left.right, right.left);
    }
}
