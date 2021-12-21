package LeetCode.binarytree;

import LeetCode.LcTemplate;

public class Lc0114FlattenBinaryTreeToLinkedList implements LcTemplate {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        _flatten(root);
    }

    private TreeNode _flatten(TreeNode root) {
        TreeNode leftend = root, rightend = root;
        TreeNode temp = root.right;
        if (root.left != null) {
            leftend = _flatten(root.left);
        }
        if (root.right != null) {
            rightend = _flatten(root.right);
        }
        if (leftend != root) {
            root.right = root.left;
            root.left = null;
        }
        if (rightend != root) {
            leftend.right = temp;
        } else {
            rightend = leftend;
        }
        return rightend;
    }
}
