package code;

import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(3).
 * Logic is
 * 1. Take two pointers. One pointer points to current. Second pointer is a fast forward pointer. It first goes to place where
 * the distance between current pointer and fast pointer is n.
 * 2. Now traverse the list till the fast pointer reaches the end of the list. So that current pointer points to the
 * node to be removed.
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        ListNode current = head;
        ListNode fastPointer = head;
        int count = 0;
        //Fast forward the current pointer.
        while (count != n && fastPointer.next != null) {
            fastPointer = fastPointer.next;
            count++;
        }
        if (count == n - 1) {
            return root.next;
        }
        if (count < n) {
            return null;
        }
        count = 0;
        //Traverse the list till the fast pointer is the end one.
        while (current != null && fastPointer.next != null) {
            current = current.next;
            fastPointer = fastPointer.next;
        }
        current.next = current.next.next;
        return root;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;

//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode root = new RemoveNthNodeFromEndOfList().removeNthFromEnd(node, 2);
        System.out.println(root);
    }

}