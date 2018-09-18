package code;

import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n/2)
 * Logic here is :
 * 1. For every occurence of ( or { or [ put in stack.
 * 2. For every occurence of ) or } or ] check corresponding stack element .
 * If the stack element is not satisfying the parenthesis, then it is invalid.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(s.charAt(i)); //Push to stack.
            } else {
                if (stack.isEmpty()) {
                    return false; //Edge case check for first character to be ')'
                } else {
                    char old = stack.pop().charValue();
                    //Individual element comparision.
                    if (ch == '}' && old != '{') {
                        return false;
                    } else if (ch == ')' && old != '(') {
                        return false;
                    } else if (ch == ']' && old != '[') {
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new ValidParentheses().isValid(s));
    }
}