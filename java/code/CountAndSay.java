package code;

/**
 * Logic is to do following steps.
 * 1. Value of current n will come from n -1
 * 2. Count of current n will be nothing but count of sequence of numbers followed by the
 * number itself.
 */
public class CountAndSay {

    public String count(String str) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        String last = "";
        for (int i = 0; i < str.length(); i++) {
            String cur = str.charAt(i) + "";
            if ((last.equals(cur)) || (last.equals(""))) {
                count++;
            } else {
                result.append(count).append(last);
                count = 1;
            }
            last = cur;
        }
        result.append(count).append(last);
        return result.toString();
    }

    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }
        return count((countAndSay(n - 1)));
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(30));
        //System.out.println(new CountAndSay().count(21));
    }
}