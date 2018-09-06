package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Time Complexity: O(n)
 To check the tree is balanced, we calculate the Depth (Max Height) of the tree.
 During the depth calculation if the difference between left node depth and right node depth
 is > 1 , then it is not a balanced tree.
 Solved the same logic using the below recursive method.
 */
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
        //Main condition to check the depth
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
