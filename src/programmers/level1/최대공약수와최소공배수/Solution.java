package programmers.level1.최대공약수와최소공배수;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int n = 36;
        int m = 24;

        System.out.println(Arrays.toString(solution(n, m)));

    }

    static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);

        answer[0] = gcd;

        answer[1] = answer[0] * (n/gcd) * (m/gcd);

        return answer;
    }

    static int gcd(int n, int m) {
        if (n < m) {
            return gcd(m, n);
        }
        if (m != 0) {
            return gcd(m, n % m);
        }
        return n;
    }

}