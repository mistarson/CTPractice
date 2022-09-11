package programmers.큰수만들기;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));

    }
    static String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int removeCnt = k;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && removeCnt > 0) {
                removeCnt--;
                stack.pop();
            }
            stack.push(c);
        }

        int size = stack.size();
        if (size == number.length()) {
            for (int i = 0; i < k ; i++) {
                stack.pop();
            }
        }
        for (int i = 0; i < number.length() - k; i++) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}
