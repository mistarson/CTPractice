package programmers.문자열압축;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "aabbaccc";

        int solution = solution(s);

        System.out.println(solution);

    }

    static int solution(String s) {
        int answer = 0;
        int minLength = Integer.MAX_VALUE;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            String originalStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length() / i; j++) {
                String comparisonStr = s.substring(j * i, j * i + i);

                if (originalStr.equals(comparisonStr)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(originalStr);
                    originalStr = comparisonStr;
                }
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(originalStr);

            if (s.length() % i != 0) {
                sb.append(s.substring((s.length() / i) * i, s.length()));
            }
            minLength = Math.min(minLength, sb.length());
        }

        return answer = minLength;
    }
}
