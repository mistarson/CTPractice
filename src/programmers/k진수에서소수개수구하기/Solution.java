package programmers.k진수에서소수개수구하기;

import java.util.*;

public class Solution {
    static int solution(int n, int k) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.add(n % k);
            n /= k;

            if (n < k) {
                stack.add(n);
                break;
            }
        }

        int size = stack.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), "0");

        int countTokens = st.countTokens();
        int[] numbers = new int[countTokens];
        for (int i = 0; i < countTokens; i++) {
            long num = Long.parseLong(st.nextToken());
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
