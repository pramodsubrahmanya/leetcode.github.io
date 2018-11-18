package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShortenUrl {


    static String shortenUrl(String input, int start) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println(sb.toString());
        String hash = sb.toString().substring(start, start + 8);
        //https://www.shutterfly.com/mobile
        String prefix = "https://sf.ly/";
        return prefix + hash;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            int start = 0;
            while ((line = br.readLine()) != null) {
                String url = line.trim();
                System.out.println(shortenUrl(url, start));
                start++;
                if (start == 31) {
                    start = 0;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}