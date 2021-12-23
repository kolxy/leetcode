package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class LC0111MinimumDepthOfBinaryTree implements LcTemplate {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();

        int depth = 1;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean end = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    end = true;
                    break;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (end) {
                break;
            }
            depth++;
        }
        return depth;
    }
}
