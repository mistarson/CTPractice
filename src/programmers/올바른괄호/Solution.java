package programmers.올바른괄호;

import java.util.Stack;

public class Solution {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }else stack.add(c);
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
