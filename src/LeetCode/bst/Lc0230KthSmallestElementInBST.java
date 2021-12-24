package LeetCode.bst;

import LeetCode.LcTemplate;

public class Lc0230KthSmallestElementInBST implements LcTemplate {
    @Override
    public void run() {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int val;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k, 0);
        return val;
    }

    public int traverse(TreeNode root, int k, int count) {
        if (root == null) {
            return count;
        }
        int current = traverse(root.left, k, count) + 1;
        if (current == k) {
            val = root.val;
        }
        current = traverse(root.right, k, current);
        return current;
    }
}
