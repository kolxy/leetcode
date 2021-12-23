package LeetCode.binarytree;

import LeetCode.LcTemplate;

public class Lc0222CountCompleteTreeNodes implements LcTemplate {
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = 1, depthRight = 1;
        TreeNode left = root.left, right = root.right;
        while (left != null) {
            left = left.left;
            depthLeft++;
        }
        while (right != null) {
            right = right.right;
            depthRight++;
        }

        if (depthLeft == depthRight) {
            return (int) (Math.pow(2, depthLeft) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
