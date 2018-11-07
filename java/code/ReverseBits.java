package code;

public class ReverseBits {

    public int reverseBits(int n) {
        System.out.println(n);
        long k = n;
        long res = 0;
        int pow = 31;
        StringBuilder result = new StringBuilder();
        while (k != 0) {
            long rem = k % 2;
            res += rem * Math.pow(2, pow);
//            result.insert(0, rem);
            k = k / 2;
            pow--;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        String n = "2147483649";
//        int x = Integer.parseUnsignedInt("2147483648");
        //System.out.println();
        System.out.println(new ReverseBits().reverseBits(Integer.parseInt(n)));
    }

}
