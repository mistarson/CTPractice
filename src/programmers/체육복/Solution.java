package programmers.체육복;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4,5};
        int[] reserve = {1,4};

        int solution = solution(n, lost, reserve);

        System.out.println(solution);

    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] canBorrow = new boolean[n + 1];
        boolean[] needCheck = new boolean[n + 1];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            canBorrow[reserve[i]] = true;
        }

        for (int i = 0; i < lost.length; i++) {
            needCheck[lost[i]] = true;
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    canBorrow[lost[i]] = false;
                    needCheck[lost[i]] = false;
                    answer++;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            int index = lost[i];
            if (!needCheck[index]) {
                continue;
            }
            if (index - 1 >= 1 && canBorrow[index - 1]) {
                answer++;
                canBorrow[index - 1] = false;
            } else if (index + 1 <= n && canBorrow[index + 1]) {
                answer++;
                canBorrow[index + 1] = false;
            }
        }
        return answer;
    }

}
