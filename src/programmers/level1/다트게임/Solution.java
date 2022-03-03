package programmers.level1.다트게임;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        System.out.println(solution(dartResult));
    }

    static int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        String regx = "^[0-9]*$";

        int j = 0;
        for (int i = 0; i < 3; i++) {
            int n = dartResult.charAt(j++) - '0';
            if (String.valueOf(dartResult.charAt(j)).matches(regx)) {
                n = Integer.parseInt(dartResult.substring(j - 1, j + 1));
                j++;
            }
            int pow = pow(dartResult.charAt(j++));
            n = (int)Math.pow(n, pow);
            if (j < dartResult.length()) {
                if (dartResult.charAt(j) == '*') {
                    if (j != 2) {
                        list.set(i-1, list.get(i-1) * 2);
                    }
                    n *= 2;
                    j++;
                } else if (dartResult.charAt(j) == '#') {
                    n *= -1;
                    j++;
                }
            }
            list.add(n);
        }

        for (Integer n : list) {
            answer += n;
        }
        return answer;
    }

    static int pow(char c) {
        if (c == 'S') {
            return 1;
        } else if (c == 'D') {
            return 2;
        } else {
            return 3;
        }
    }
}
