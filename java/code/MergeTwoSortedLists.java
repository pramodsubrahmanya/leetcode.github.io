package code;

import java.util.List;

/**
 * Time Complexity: O(n)
 * Merging two lists uses second half logic of Merge sort.
 * Concept is :
 * 1. Take each element of the firs list and compare with the
 * first element of the second list. Whichever is the smallest add it to the result list and
 * proceed with the next elements.
 * 2. Once all the elements are compared, one of the two lists will have elements
 * that will be left over without being compared.
 * Iterate them and add those to the result list.
 *
 * @author Pramod ( @pramodnanduri)
 */
public class MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode result = node;
        ListNode first = l1;
        ListNode second = l2;
        //Comapre with the first element of the second list and add to result list.
        while (first != null && second != null) {
            if (first.val < second.val) {
                node.next = new ListNode(first.val);
                first = first.next;
            } else {
                node.next = new ListNode(second.val);
                second = second.next;
            }
            node = node.next;
        }

        //Loops for iterating the left over elements
        while (first != null) {
            node.next = new ListNode(first.val);
            first = first.next;
            node = node.next;
        }

        while (second != null) {
            node.next = new ListNode(second.val);
            second = second.next;
            node = node.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        //Input: 1->2->4, 1->3->4;
        ListNode first = new ListNode(-9);
        ListNode node2 = new ListNode(3);

        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(7);

        first.next = node2;
        node4.next = node3;

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(first, node4));
    }
}