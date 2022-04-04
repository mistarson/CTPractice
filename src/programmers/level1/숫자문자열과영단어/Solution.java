package programmers.level1.숫자문자열과영단어;

public class Solution {
    public static void main(String[] args) {

        String s = "2three45sixseven";

        System.out.println(solution(s));

    }

    static int solution(String s) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            s = s.replaceAll(str[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
