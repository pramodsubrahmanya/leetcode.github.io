package code;

public class ReverseListNodesInKGroups {

    /**
     * TimeComplexity: O(n)
     * SpaceComplexity: O(constant)
     * Logic :
     * Combination of recursion and iterative solution.
     * 1. Keep track of the start, current, prev, next locations.
     * 2. Reverse the elements till k elements. Then point the
     * original pointer with the head of the recursive version
     * of the next sublist.
     *
     * @author Pramod (@pramodnanduri)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current;
        ListNode start = head;
        int n = 0;

        //Looping through the list in combination with recursion
        //to reverse in groups.
        while (n < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            n++;
            if (n == k) {
                start.next = reverseKGroup(current, k);
            }
        }
        //This is to undo the reverse for the elements that are less than length k
        //at the end of the list.
        if (n < k && current == null) {
            return reverseKGroup(prev, n);
        }

        return prev; //Previous is the one that gives the actual result.
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        first.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 3;

        System.out.println(new ReverseListNodesInKGroups().reverseKGroup(first, k));
    }

}