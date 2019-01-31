package code;

import java.util.Arrays;

public class Heaters {

    public static void main(String[] args) {
//        int[] houses = new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
//        int[] heaters = new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
//        int[] houses = new int[]{581030105, 557810404, 146319451, 908194298, 500782188, 657821123};
//        int[] heaters = new int[]{102246882, 269406752, 816731566, 884936716, 807130337, 578354438};
        int[] houses = new int[]{1, 2, 3};
        int[] heaters = new int[]{2};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }

    public int getNearest(int[] heaters, int house) {
        int mid = 0;
        int start = 0;
        int end = heaters.length - 1;
        if (heaters.length == 1) {
            return Math.abs(house - heaters[0]);
        }

        int min = Integer.MAX_VALUE;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (heaters[mid] == house) {
                return 0;
            }
            if (house > heaters[mid]) {
                start = mid + 1;
            } else if (house < heaters[mid]) {
                end = mid;
            }

            int val = Math.min(Math.min(Math.abs(house - heaters[start]), Math.abs(house - heaters[end])),
                    Math.abs(house - heaters[mid])
            );

            if (val < min) {
                min = val;
            }
        }

        return min;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int dist = getNearest(heaters, houses[i]);
            if (dist > max) {
                max = dist;
            }
        }
        return max;
    }

}