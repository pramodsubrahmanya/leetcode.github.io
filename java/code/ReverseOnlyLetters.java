package code;

public class ReverseOnlyLetters {
    //65 to 90 && 97 to 122
    public String reverseOnlyLetters(String S) {
        char[] result = S.toCharArray();
        int i = 0;
        int j = S.length() - 1;
        while (i < j) {
            int a = result[i];
            int b = result[j];
            if (!((a >= 65 && a <= 90) || (a >= 97 && a <= 122))) {
                i++;
            } else if (!((b >= 65 && b <= 90) || (b >= 97 && b <= 122))) {
                j--;
            } else {
                char temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String S = "Test1ng-Leet=code-Q!";
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters(S));
    }

}