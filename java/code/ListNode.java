package code;

public class ListNode {
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