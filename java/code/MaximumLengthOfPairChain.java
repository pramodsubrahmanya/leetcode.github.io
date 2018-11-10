package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority queue based solution.
 * Add the Pairs say (a,b) to the queue by sorting the elements using b.
 * Now iterate the queue by keeping track of the last and current and comparign the
 * pairs by a.
 */
public class MaximumLengthOfPairChain {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int findLongestChain(int[][] pairs) {

        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.b >= o2.b ? 1 : -1;
            }
        });
        for (int i = 0; i < pairs.length; i++) {
            queue.add(new Pair(pairs[i][0], pairs[i][1]));
        }

        int length = 1;
        Pair last = queue.poll();
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.a > last.b) {
                last = current;
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };

        int[][] pairs1 = new int[][]{
                {1, 4},
                {2, 3},
                {5, 9},
                {6, 7},
                {3, 7},
                {3, 4},
                {8, 10}
        };
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs1));
    }
}