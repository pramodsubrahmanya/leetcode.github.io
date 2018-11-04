package code;

/**
 * Logic is :
 * Do Inorder traversal by comparing with each node of the two trees.
 */
public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val != q.val) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(new SameTree().isSameTree(p, q));
    }

}