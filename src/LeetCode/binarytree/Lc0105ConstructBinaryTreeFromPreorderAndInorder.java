package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.HashMap;
import java.util.Map;

public class Lc0105ConstructBinaryTreeFromPreorderAndInorder implements LcTemplate {
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

    Map<Integer, Integer> hash = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int k = hash.get(root.val);
        TreeNode left = dfs(pl+1, pl + k - il, il, k - 1);
        TreeNode right = dfs(pl+k-il+1, pr, k+1, ir);
        root.left = left;
        root.right = right;
        return root;
    }
}
