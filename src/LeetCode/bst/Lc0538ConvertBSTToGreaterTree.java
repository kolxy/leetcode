package LeetCode.bst;

import LeetCode.LcTemplate;

public class Lc0538ConvertBSTToGreaterTree implements LcTemplate {
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

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.val = traverse(root.right, 0) + root.val;
        int result = traverse(root.left, root.val);
        return root;
    }

    public int traverse(TreeNode root, int val) {
        if (root == null) {
            return val;
        }
        root.val = traverse(root.right, val) + root.val;
        int result = traverse(root.left, root.val);
        return result;
    }
}
