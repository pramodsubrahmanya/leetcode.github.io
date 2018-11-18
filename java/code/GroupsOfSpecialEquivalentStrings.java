package code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsOfSpecialEquivalentStrings {

    boolean compare(String a, String b) {
        int xor = 0;
        for (int i = 0; i < a.length(); i = i + 2) {
            xor ^= a.charAt(i) ^ b.charAt(i);
        }

        if (xor == 0) {
            for (int i = 1; i < a.length(); i = i + 2) {
                xor ^= a.charAt(i) ^ b.charAt(i);
            }
            if (xor == 0) {
                return true;
            }
        }

        return false;
    }

    public int numSpecialEquivGroups(String[] A) {



        for (int i = 0; i < A.length; i++) {
            if (A[i] != null) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] != null && compare(A[j], A[i])) {
                        A[j] = null;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] input = {
                "naxeixzzxqlsekzdzefi", "wlerclymemtfnakxmtvq", "mhwnbuwtvmqqceimnypr", "bulmctscpvrvkfevhyoo", "jggtfippwywhsvkkezke",
                "ldmgzrwdnuspmqyxxanp", "mscqvootxbhbhirejnwc", "faadquvjpysknlaxhxot", "sfzroqxiiqrcmfthavhi", "vshdpffkdlmfpwovuuet",
                "yeodwmzpyuuaeuprmxax", "updtulswuiqpktefjkkz", "xwmtcajmxdjawefmrhkn", "aaxodqtjpagggbqubdym", "kfgrflodqfjkiglkqdce",
                "narefcacncsmrqutsvzo", "floocrafrenuwhmqkydn", "jgdbdjiasgzyksjkidau", "aufzfpxwqslnekanwqym", "bjoxmkktjsmxzemnrfjr",
                "lrbkyyrojqkbxzujaybm", "kpccivvmbzfhelcdbeby", "pisctytkfndsuabftwal", "tumoyafxefizneaojkje", "iuvsjndkimhaodehygzc",
                "akmgbtivxxwojbywubsr", "audasydbzdigjkjsigkj", "vihncorqmcwbxthsjboe", "bxmfktjjmkoszrrxmnje", "vzclbmieevbdcpkhbcfy",
                "tcfytndfsiusaabkpltw", "updputszqtukeljfkwki", "jxmjkrjnbxzemkotmfrs", "wtmexhxmcnjwjarafdkm", "mbyoavjtxxskbbugwwir",
                "aulkqpfqxwwsazfmynen", "xqfazszeexndielkzzxi", "dhvajdhkiceuisygzmon", "mjonrrjtbxzxjsmkmfke", "iiacoihrmhzqxfrqsftv",
                "laypnrxpsgwxndzdmumq", "okndfyvusjalathxpaqx", "mkiajonefzyoaujeextf", "uwufszekkpupktjldiqt", "jaohvmykduinzsedhcig",
                "qahtacxzqwzpfatzpbzr", "survptlvcchyevboofkm", "ktepklufupszdwutjiqk", "rwfmmtxnjdkaxmwechja", "vxyawletemkfcqtrnmml"};
        //String[] input = {"abcd","cdab","adcb","cbad"};
        System.out.println(new GroupsOfSpecialEquivalentStrings().numSpecialEquivGroups(input));

    }


}