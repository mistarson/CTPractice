package programmers.level2.괄호변환;

import java.util.Stack;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        String p = "()))((()";

        String solution = solution(p);

        System.out.println(solution);

    }

    static String solution(String p) {

        bracketConversion(p);

        return sb.toString();
    }

    static void bracketConversion(String p) {
        if (p.isEmpty()) {
            return;
        }

        int openCnt = 0;
        int closeCnt = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++) {

            if (isOpenBracket(p.charAt(i))) {
                openCnt++;
            } else {
                closeCnt++;
            }

            if (openCnt == closeCnt) {
                index = i;
                break;
            }
        }
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if (isCorrectBracket(u)) {
            sb.append(u);
            bracketConversion(v);
        } else {
            sb.append("(");
            bracketConversion(v);
            sb.append(")");
            sb.append(reverseBracket(u));
        }
    }

    static Boolean isOpenBracket(char c) {
        if (c == '(') {
            return true;
        }
        return false;
    }

    static Boolean isCorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();
        if (!isOpenBracket(s.charAt(0))) {
            return false;
        }
        stack.push('(');
        for (int i = 1; i < s.length(); i++) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    static String reverseBracket(String s) {
        StringBuilder sbb = new StringBuilder();
        String substring = s.substring(1, s.length() - 1);
        for (int i = 0; i < substring.length(); i++) {
            if (isOpenBracket(substring.charAt(i))) {
                sbb.append(")");
            } else sbb.append("(");
        }
        return sbb.toString();
    }

}
