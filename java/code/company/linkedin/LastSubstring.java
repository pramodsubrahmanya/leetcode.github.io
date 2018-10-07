package code.company.linkedin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastSubstring {
    public static void main(String[] args) {
        String s = "abc";
        new LastSubstring().generatePermutations(s);
    }

    void generatePermutations(String s) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                queue.add(s.substring(i, j));
            }
        }
        System.out.println(queue);
    }

}