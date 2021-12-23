package LeetCode.binarytree;

import LeetCode.LcTemplate;

public class Lc0654MaximumBinaryTree implements LcTemplate {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maximum(nums, 0, nums.length-1);
    }

    public TreeNode maximum(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maximum(nums, left, maxIndex - 1);
        root.right = maximum(nums, maxIndex + 1, right);
        return root;
    }
}
