package code;

public class BinaryGap {

    public int binaryGap(int N) {
        int last = -1;
        int first = -1;
        int i = 1;
        int max = 0;
        while (N != 0) {
            int rem = N % 2;
            if (rem == 1) {
                if (first == -1) {
                    first = i;
                } else {
                    int dist = i - first;
                    if (max < dist) {
                        max = dist;
                    }
                    first = i;
                }
            }
            N = N / 2;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int N = 8;
//        N = 22;
        System.out.println(new BinaryGap().binaryGap(N));
    }

}