package programmers.이진변환반복하기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] solution = new Solution().solution("1");
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            answer[0]++;
            int zeroCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
            }
            s = s.replaceAll("0", "");
            answer[1] += zeroCnt;
            int length = s.length();
            s = Integer.toBinaryString(length);
        }
        return answer;
    }
}
