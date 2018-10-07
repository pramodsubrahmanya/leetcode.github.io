package code;


import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode candidate = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right == null) {
                node.right = new TreeNode(v);
                return node.val;
            }
            if (node.left == null && node.right != null) {
                node.left = new TreeNode(v);
                return node.val;
            }
            if (node.left == null && node.right == null && candidate == null) {
                candidate = node;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        candidate.left = new TreeNode(v);
        return candidate.val;
    }


    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {

    }

}