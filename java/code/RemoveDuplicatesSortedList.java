package code;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Because the input list is sorted, we can determine if a node is a duplicate by comparing its value to the node after it in the list.
 * If it is a duplicate, we change the next pointer of the current node so that it skips the next node and points directly to the one after the next node.
 */
public class RemoveDuplicatesSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next; //Skip next node iteration.
            } else {
                node = node.next; //Move current pointer.
            }
        }
        return head;
    }


}
