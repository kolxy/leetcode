package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc0652FindDuplicateSubtrees implements LcTemplate {
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

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> answer = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return answer;
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return "x";
        }

        String id = root.val + "," + traverse(root.left) + "," + traverse(root.right);
        int freq = map.getOrDefault(id, 0);
        if (freq == 1) {
            answer.add(root);
        }
        map.put(id, freq+1);
        return id;
    }
}
