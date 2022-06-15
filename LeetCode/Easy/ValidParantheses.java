package DATA_STRUCTURE.LeetCode.Easy;

import java.util.*;

public class ValidParantheses {
    static boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        stk.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stk.isEmpty()) {
                if (stk.peek() == '(' && s.charAt(i) == ')') {
                    stk.pop();
                } else if (stk.peek() == '[' && s.charAt(i) == ']') {
                    stk.pop();
                } else if (stk.peek() == '{' && s.charAt(i) == '}') {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            } else {
                stk.push(s.charAt(i));
            }
        }
        if (stk.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
