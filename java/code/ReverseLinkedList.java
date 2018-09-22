package code;

public class ReverseLinkedList {

    /**
     * TimeComplexity: O(n).
     * SpaceComplexity: O(3).
     * Logic is to mainatain 3 pointers.
     * Current, Prev, Next - Names are self explanatory.
     * So changing the references of individual pointers gives the desired output.
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current;
        while (current != null) {
            next = current.next; //Remembering next node to go.
            current.next = prev; //Modify current pointers reference.
            prev = current; //Modify previous pointer reference.
            current = next; //Move current pointer to the next node.
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

        System.out.println(new ReverseLinkedList().reverseList(first));
    }
}