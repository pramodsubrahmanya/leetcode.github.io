package code;

/**
 * This is an awesome conceptual question.
 * Input integer n , is depicted as bit string of 32 bits.
 * Each bit of the input is 'OR' with (31-i) times of the
 * input position.
 * Eg: Input: 0001
 * So answer would be : sum = sum | (1 << 31-i))
 * i is the current position.
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int mask = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum = sum | (1 << (31 - i));
            }
            mask <<= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String n = "2147483649";
        n = "1";
        System.out.println(new ReverseBits().reverseBits(Integer.parseInt(n)));
    }

}
