package code;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDiameter {

    static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    int diameter(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return 1 + height(root.right);
        } else if (root.right == null) {
            return 1 + height(root.left);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        while (queue.size() != 0) {
            Node node = queue.poll();
            int left = height(node.left);
            int right = height(node.right);
            int diameter = 1 + left + right;
            if (max < diameter) {
                max = diameter;
            }
            if (left < right) {
                if (node.left != null) {
                    queue.add(node.left);
                }
            } else {
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node node = new Node(18);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node.left = node1;
        node1.left = node9;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node8;
        node4.left = node5;
        node4.right = node6;

        System.out.println(new TreeDiameter().diameter(node));

    }


}
