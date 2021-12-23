package LeetCode.binarytree;

import LeetCode.LcTemplate;

import java.util.LinkedList;
import java.util.Queue;

public class Lc0297SerializeAndDeserializeBinaryTree implements LcTemplate {
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

    String SEP = ",";
    String NUL = "x";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NUL;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append(NUL);
            } else {
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            sb.append(SEP);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == NUL) {
            return null;
        }

        String[] vals = data.split(SEP);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int index = 1;

        while(index < vals.length) {
            TreeNode node = q.poll();
            if (node != null) {
                TreeNode child;
                if (vals[index].equals(NUL)) {
                    child = null;
                } else {
                    child = new TreeNode(Integer.parseInt(vals[index]));
                }
                node.left = child;
                q.offer(child);
                index++;

                if (vals[index].equals(NUL)) {
                    child = null;
                } else {
                    child = new TreeNode(Integer.parseInt(vals[index]));
                }
                node.right = child;
                q.offer(child);
                index++;
            }
        }

        return root;
    }
}
