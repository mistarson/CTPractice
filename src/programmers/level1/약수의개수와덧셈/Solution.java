package programmers.level1.약수의개수와덧셈;

public class Solution {
    public static void main(String[] args) {

        int left = 13;
        int right = 17;

        System.out.println(solution(left, right));
    }

    static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            int divisorCnt = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    divisorCnt++;
                    if (i / j != j) {
                        divisorCnt++;
                    }
                }
            }
            System.out.println(divisorCnt);
            if (divisorCnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }

        }

        return answer;
    }
}
