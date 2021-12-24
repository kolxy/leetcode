package LeetCode.bst;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Lc0095UniqueBinarySearchTrees2 implements LcTemplate {
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

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int min, int max) {
        List<TreeNode> nodes = new ArrayList<>();
        if (min > max) {
            nodes.add(null);
            return nodes;
        }
        if (min == max) {
            nodes.add(new TreeNode(min));
            return nodes;
        }
        for(int i = min; i <= max; i++) {
            List<TreeNode> left = generate(min, i-1);
            List<TreeNode> right = generate(i+1, max);
            for(int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode tmp = new TreeNode(i, left.get(j), right.get(k));
                    nodes.add(tmp);
                }
            }
        }
        return nodes;
    }
}
