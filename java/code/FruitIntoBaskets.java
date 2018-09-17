package code;

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = 0;

        for (int i = 0; i < tree.length; i++) {
            int fruit = tree[i];
            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + 1);
            } else {
                map.put(fruit, 1);
            }

            if (map.size() > 2) {
                max = Math.max(max, i - start);

                while (map.size() > 2) {
                    int element = tree[start];
                    int count = map.get(element);
                    if (count > 1) {
                        map.put(element, count - 1);
                    } else {
                        map.remove(element);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, tree.length - start);
        return max;
    }

    public int totalFruit1l(int[] tree) {
        int total = 0;
        if (tree.length == 1) {
            return 1;
        }
        for (int i = 0; i < tree.length - 1; i++) {
            int b1 = tree[i];
            int b2 = tree[i + 1] == tree[i] ? -1 : tree[i + 1];
            int count = 0;
            for (int j = i; j < tree.length; j++) {
                if (tree[j] == b1) {
                    count++;
                } else {
                    if (b2 == -1 || b2 == tree[j]) {
                        b2 = tree[j];
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count > total) {
                total = count;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 2};
        System.out.println(new FruitIntoBaskets().totalFruit(input));
    }

}
