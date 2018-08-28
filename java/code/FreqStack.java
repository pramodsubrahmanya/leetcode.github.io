package code;

import java.util.*;

public class FreqStack {

    Map<Integer, Integer> map = new LinkedHashMap<>();
    List<Integer> list = new ArrayList<>();

    public FreqStack() {
    }

    public void push(int x) {
        if (map.containsKey(x)) {
            map.put(x, map.get(x) + 1);
        }
        list.add(x);
    }

    public int pop() {
        int max = Integer.MIN_VALUE;
        int element = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                element = key;
            }
        }

        list.remove(element);
        return element;
    }

    public static void main(String[] args) {

    }
}