package code;

public class SwapNodesInPairs {

    /**
     * TimeComplexity: O(n)
     * Space Complexity: O(3)
     * Logic is
     * 1. Swap the elements by modifying the pointers.
     * 2. For simplicity add a dummy node -1 in the beginning .
     * So in a loop iterate by skipping alternate elements and swapping two consecutive ones.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pointer = result;

        ListNode temp = null;
        while (pointer != null && pointer.next != null && pointer.next.next != null) {
            temp = pointer.next;
            pointer.next = temp.next;
            temp.next = pointer.next.next;
            pointer.next.next = temp;
            pointer = pointer.next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new SwapNodesInPairs().swapPairs(node1));
    }

}