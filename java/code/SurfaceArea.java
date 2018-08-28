package code;

public class SurfaceArea {

    int surfaceArea(int A[][]) {
        int aread = 0;
        int X = A.length;
        int Y = A[0].length;

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                int areaUp = 0;
                int areaLeft = 0;
                if (i > 0) {
                    areaUp = A[i - 1][j];
                }
                if (j > 0) {
                    areaLeft = A[i][j - 1];
                }
                aread += Math.abs(A[i][j] - areaUp) + Math.abs(A[i][j] - areaLeft);
                if (i == X - 1) {
                    aread += A[i][j];
                }
                if (j == Y - 1) {
                    aread += A[i][j];
                }
            }
        }
        aread += X * Y * 2 - 4;
        return aread;
    }

    public static void main(String[] args) {
        // int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] grid = {{1, 0}, {0, 2}};
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(new SurfaceArea().surfaceArea(grid));
    }
}
