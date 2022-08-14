package programmers.문자열압축;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";

        int solution = solution(s);

        System.out.println(solution);

    }

    static int solution(String s) {
        int length = s.length();

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= length / 2; i++) {
            String originalStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for (int j = 1; j < length / i; j++) {
                String compareStr = s.substring(j * i, j * i + i);

                if (originalStr.equals(compareStr)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(originalStr);
                    originalStr = compareStr;
                }
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(originalStr);

            if (length % i != 0) {
                sb.append(s.substring((length / i) * i, length));
            }
            min = Math.min(min, sb.length());
        }
        return min;
    }
}
