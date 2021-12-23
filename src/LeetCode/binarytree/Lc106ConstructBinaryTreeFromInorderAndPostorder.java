package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.HashMap;
import java.util.Map;

public class Lc106ConstructBinaryTreeFromInorderAndPostorder implements LcTemplate {
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
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int il, int ir, int pl, int pr) {
        if (pl > pr || il > ir) {
            return null;
        }
        int index = hash.get(postorder[pr]);
        TreeNode root = new TreeNode(postorder[pr]);
        TreeNode left = build(il, il +  index - 1, pl, pl + index - il - 1);
        TreeNode right = build(index + 1, ir, pl + index - il, pr - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
