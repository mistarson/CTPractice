package programmers.level2.멀쩡한사각형;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        int w = 100000000;
        int h = 100000000;

        long solution = solution(w, h);

        System.out.println(solution);


    }

    static long solution(int w, int h) {
        long answer = 1;
        int gcd = gcd(w, h);
        answer = ((long) w * h) - ((((long)w / gcd) + ((long)h / gcd) - 1) * gcd);
        return answer;
    }

    static int gcd(int w, int h) {
        if (w < h) {
            return gcd(h, w);
        }
        if (h == 0) {
            return w;
        }

        return gcd(h, w % h);
    }
}
