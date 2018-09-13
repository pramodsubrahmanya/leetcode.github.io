package code;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        //Compare each character of input string with character in the same position of
        //all the remaining characters.
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                try {
                    if (strs[0].charAt(i) != strs[j].charAt(i)) {
                        return result;
                    }
                } catch (Exception ex) {
                    return result; //If the Length crossed the minimum length string.
                }
            }
            result += strs[0].charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

}
