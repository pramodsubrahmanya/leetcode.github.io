package code;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            int count = needle.length();
            for (int j = 0; j < needle.length(); j++) {
                if (k == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    count--;
                } else {
                    break;
                }
                if (count == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String needle = "dd";
        String haystack = "d";
        System.out.println(new ImplementStrStr().strStr(haystack, needle));
    }

}
