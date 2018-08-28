package code;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int j = i;
            boolean alt = true;
            while (j < n) {
                //if (alt) {
                result.append(s.charAt(j));
//                    result.append(j + ",");
                //}

                if (i == numRows - 1) {
                    j = 2 * (numRows - 1) - 1 + j + 1;
                    alt = false;
                } else if (alt || i == 0) {
                    j = 2 * (numRows - (1 + i)) - 1 + j + 1;
                    alt = false;
                } else {
                    j = 2 * (i) - 1 + j + 1;
                    alt = true;
                }

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        //PAHNAPLSIIGYIR
        int numRows = 1;
        System.out.println(new ZigZagConversion().convert(s, numRows));
    }
}
