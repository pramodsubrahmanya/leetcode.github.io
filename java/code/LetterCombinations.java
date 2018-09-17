package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations of strings are generated using recursion.
 * Eg: Input : 23
 * 2 -> a,b,c
 * 3 -> d,e,f
 * Each character of 2 is recursively combined with
 * sub characters of 3. Recursion is used because the input string length could be
 * more than 2 character length.
 * Eg2: Input: 456
 * Combinations(456) = Characters(4) + Combinations(56).
 *
 * @author Pramod Nanduri (@pramodnanduri)
 */
public class LetterCombinations {

    //String initialization.
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Takes two lists and generated combinations of
     * each list elements with the other list elements.
     */
    public List<String> combinationsOfTwoLists(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                result.add(a.get(i) + b.get(j));
            }
        }
        return result;
    }

    /**
     * Method that converts string to a list of character strings.
     * Eg: "abc" -> {"a", "b", "c"}
     */
    private List<String> getStringAsList(String string) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            result.add(string.charAt(i) + "");
        }
        return result;
    }

    /**
     * Recursive logic used here.
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        //Base Cases.
        if (digits.length() == 0) {
            return result;
        }
        if (digits.length() == 1) {
            result.addAll(getStringAsList(str[digits.charAt(0) - '0']));
            return result;
        } else {
            //The String is split into two parts.
            //1. First character.
            //2. Recursive second character.
            List<String> first = getStringAsList(str[digits.charAt(0) - '0']);
            List<String> subs = letterCombinations(digits.substring(1));
            result.addAll(combinationsOfTwoLists(first, subs));
        }
        return result;
    }

    public static void main(String[] args) {
        String case1 = "23";
        System.out.println(new LetterCombinations().letterCombinations(case1));

        String case2 = "456";
        System.out.println(new LetterCombinations().letterCombinations(case2));
    }

}