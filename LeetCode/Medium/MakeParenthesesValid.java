package DATA_STRUCTURE.LeetCode.Medium;

import java.util.*;

public class MakeParenthesesValid {
    // Success

    public static int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        stk.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stk.isEmpty()) {
                if (stk.peek() == '(' && s.charAt(i) == ')') {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            } else {
                stk.push(s.charAt(i));
            }
        }
        return stk.size();
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(minAddToMakeValid(s));
    }
}
