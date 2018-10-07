package code;

import java.util.*;

public class SortCharactersByFrequency {
    static class Element {
        Element(char ch) {
            this.ch = ch;
        }

        char ch;
        Integer count = 0;
    }

    public String frequencySort(String s) {
        Queue<Element> queue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.count.compareTo(o1.count);
            }
        });

        Map<Character, Element> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Element ele = map.get(s.charAt(i));
            if (ele == null) {
                ele = new Element(s.charAt(i));
                map.put(s.charAt(i), ele);
            }
            ele.count++;
        }

        queue.addAll(map.values());

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Element ele = queue.poll();
            for (int i = 0; i < ele.count; i++) {
                result.append(ele.ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
    }


}