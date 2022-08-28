package programmers.짝지어제거하기;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int baabaa = new Solution().solution("baabaa");
        System.out.println(baabaa);

    }
    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                char c1 = s.charAt(i);
                if (peek == c1) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        int answer = 0;
        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

}
