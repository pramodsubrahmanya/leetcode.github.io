package code;

import java.util.*;

/**
 * For this question, consider following usecase:
 * input: aaaaabbb
 * expected: 7 because : aaaabbb
 * not all characters of the same element needs to be taken care.
 * <p>
 * So count the characters, iterate each character count by
 * summing up the even max of the count. (Eg: Count = 5 max characters
 * that can be added = 4 and if answer is even , then add + 1(this is because if answer
 * is odd, that +1 is already contributed from some other number) .
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = (int) s.charAt(i);
            Integer val = map.get(key);
            if (val == null) {
                map.put(key, 0);
                val = 0;
            }
            val++;
            map.put(key, val);
        }

        int sum = 0;
        for (Integer i : map.values()) {
            sum += (i / 2) * 2;
            if (i % 2 != 0 && sum % 2 == 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String inp = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongen" +
                "dureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafi" +
                "nalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangand" +
                "properthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallo" +
                "wthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponw" +
                "ertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverfor" +
                "getwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichthey" +
                "whofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskr" +
                "emainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygaveth" +
                "elastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisn" +
                "ationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        System.out.println(new LongestPalindrome().longestPalindrome(inp));
    }


}