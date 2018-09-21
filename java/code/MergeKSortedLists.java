package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * TimeComplexity: O(N log k). k is number of lists. N is the total number of nodes.
     * SpaceComplexity: O(N) .
     * Logic is to construct a Priority queue with each of the k list.
     * Now poll one-one element from the top list from the priority queue and add it to the result.
     * If the polled list has more elements, add the whole list back to the priority queue so that
     * it will be internally sorted in O(Log k) complexity.
     * The beauty of this logic is that Pririty queue, insertion and deletion for sorted elements
     * is O(log N). We are leveraging that functionality.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode pointer = result;

        //Creating priority queue with Node value as the comparator.
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        //Construct initial queue with all the lists.
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            //Poll each element.
            ListNode current = queue.poll();
            pointer.next = current;
            pointer = pointer.next;
            //If the list is not null add it back to the queue.
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return result.next;
    }


    //Method 2:

    /**
     * This is a second method for solving the problem.
     * Do Merge lists individually by iterating each of the lists.
     * Refer: <a href = "http://code.groupsone.com/p/merge-two-sorted-lists.html">http://code.groupsone.com/p/merge-two-sorted-lists.html</>
     * for merging two lists.
     */
    public ListNode mergeKListsIndividual(ListNode[] lists) {
        ListNode result = new ListNode(-1);

        for (int i = 0; i < lists.length; i++) {
            ListNode node = result;
            ListNode first = result.next;
            ListNode second = lists[i];
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
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                builder.append(node.val).append("->");
                node = node.next;
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node1_1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4_1 = new ListNode(4);

        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);

        node1.next = node4;
        node4.next = node5;

        node1_1.next = node3;
        node3.next = node4_1;

        node2.next = node6;

        System.out.println(node1);
        System.out.println(node1_1);
        System.out.println(node2);

        ListNode node = new MergeKSortedLists().mergeKLists(new ListNode[]{node1, node1_1});
        System.out.println("Node: " + node);
    }
}