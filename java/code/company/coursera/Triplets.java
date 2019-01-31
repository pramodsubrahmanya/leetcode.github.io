package code.company.coursera;

import java.util.*;

public class Triplets {

    public static List<String> closestColor(List<String> pixels) {
        List<String> finalResults = new ArrayList<>();
        List<String> finalR = new ArrayList<>();
        String max = null;
        String[] givenColors = new String[]{"Black", "White", "Red", "Green", "Blue"};

        for (String each : pixels) {
            List<String> grid = new ArrayList<>();
            grid.add(each.substring(0, 8));
            grid.add(each.substring(8, 16));
            grid.add(each.substring(16, 24));

            int first = Integer.parseInt(grid.get(0), 2);
            int second = Integer.parseInt(grid.get(1), 2);
            int third = Integer.parseInt(grid.get(2), 2);

            ArrayList<Double> distance = new ArrayList<>();
            distance.add(Math.sqrt(Math.pow((0 - first), 2) + Math.pow((0 - second), 2) + Math.pow((0 - third), 2)));
            distance.add(Math.sqrt(Math.pow((255 - first), 2) + Math.pow((255 - second), 2) + Math.pow((255 - third), 2)));
            distance.add(Math.sqrt(Math.pow((255 - first), 2) + Math.pow((0 - second), 2) + Math.pow((0 - third), 2)));
            distance.add(Math.sqrt(Math.pow((0 - first), 2) + Math.pow((255 - second), 2) + Math.pow((0 - third), 2)));
            distance.add(Math.sqrt(Math.pow((0 - first), 2) + Math.pow((0 - second), 2) + Math.pow((255 - third), 2)));

            double minVal = Collections.min(distance);
            int frequency = Collections.frequency(distance, minVal);
            if (frequency > 1) {
                max = "Ambiguous";
            } else {
                max = givenColors[distance.indexOf(Collections.min(distance))];
            }
            finalR.add(max);
        }
        return finalR;

    }


    static long triplets(long t, List<Integer> d) {
        Collections.sort(d);
        long result = 0;
        int n = d.size();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (d.get(i) + d.get(j) + d.get(k) > t)
                    k--;
                else {
                    result += (k - j);
                    j++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long t = 8;
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(3);

        int[] A = new int[]{5, 1, 4, 2, 6, 3};
        int a = 8;
//        System.out.println(new Triplets().threeSumMulti(A, a));
//        System.out.println(Triplets.triplets(t, list));

        //System.out.println(Triplets.triplets(list, a));

//        System.out.println(new Triplets().find3Numbers(A, A.length, a));
    }

}
