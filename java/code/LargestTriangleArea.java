package code;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {

        double res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int min[] = points[i];
                    int max[] = points[j];
                    int mid[] = points[k];

                    double area = Math.abs(min[0] * (max[1] - mid[1]) + max[0] * (mid[1] - min[1]) + mid[0] * (min[1] - max[1])) / (double) 2;
                    if (area > res) {
                        res = area;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{6, 3}, {5, 2}, {5, 8}, {0, 6}};
        System.out.println(new LargestTriangleArea().largestTriangleArea(points));
    }


}