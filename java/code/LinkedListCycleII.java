package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = MainParser.stringToListNode(line);

            ListNode p = head;
            while (p != null && p.next != null) {
                p = p.next;
            }

            ListNode q = head;
            for (int i = 0; i < 2; i++) {
                q = q.next;
            }

            p.next = q;

            ListNode ret = new LinkedListCycleII().detectCycle(head);

            String out = MainParser.listNodeToString(ret);

            System.out.print(out);
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode current = head;
        ListNode fast = head.next;

        int i = 0;

        Map<ListNode, Integer> map = new HashMap<>();

        while (current != null && fast != null && fast.next != null) {
            map.put(current, i);
            ListNode next = current.next;
            ListNode fnext = fast.next.next;
            if (fnext == null) {
                return null;
            }

            if (map.get(fast.next) != null && map.get(fast.next) <= map.get(current)) {
                //System.out.println(map.get(fast.next));
                return fast.next;
            }

            if (map.get(fast.next) != null && map.get(next) != null && map.get(fast.next) <= map.get(next)) {
                //System.out.println(map.get(fast.next) + "..");
                return fast.next;
            }
            if (map.get(fnext) != null && map.get(fnext) < map.get(current)) {
                //System.out.println(map.get(fnext) + ",,,,");
                return fnext;
            }
            current = next;
            fast = fnext;
            i++;
        }
        return null;
    }
}
