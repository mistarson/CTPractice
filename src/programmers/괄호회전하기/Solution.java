package programmers.괄호회전하기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "}}}";
        int solution = new Solution().solution(s);
        System.out.println(solution);
    }
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = shiftLeft(s);
            if (isCorrectBracket(s)) {
                answer++;
            }
        }

        return answer;
    }

    static String shiftLeft(String s) {
        StringBuilder sb = new StringBuilder();
        char temp = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(temp);

        return sb.toString();
    }

    static boolean isCorrectBracket(String BracketStr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < BracketStr.length(); i++) {
            char bracket = BracketStr.charAt(i);
            if (stack.isEmpty()) {
                if (bracket == ')' || bracket == '}' || bracket == ']') {
                    return false;
                }
            }
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
                continue;
            }
            if (!stack.isEmpty()) {
                Character peekBracket = stack.peek();
                switch (peekBracket) {
                    case '(':
                        if (bracket == ')') {
                            stack.pop();
                        }
                        break;
                    case '{':
                        if (bracket == '}') {
                            stack.pop();
                        }
                        break;
                    case '[':
                        if (bracket == ']') {
                            stack.pop();
                        }
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
