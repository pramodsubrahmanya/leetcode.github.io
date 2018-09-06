package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int result = depth(root);
        return result != -1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ldepth = depth(node.left);
        int rdepth = depth(node.right);
        if (ldepth == -1 || rdepth == -1 || Math.abs(ldepth - rdepth) > 1) {
            return -1;
        }
        return Math.max(ldepth, rdepth) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
