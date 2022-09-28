package programmers.JadenCase문자열만들기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        if (isAtoZ(chars[0])) {
            chars[0] = (char) (chars[0] - 32);
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == ' ' && isAtoZ(chars[i])) {
                chars[i] = (char) (chars[i] - 32);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            answer += chars[i];
        }

        return answer;
    }

    public boolean isAtoZ(char c) {
        return c >= 'a' && c <= 'z';
    }
}
