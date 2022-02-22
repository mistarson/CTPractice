package programmers.로또의최고순위와최저순위;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] solution = solution(lottos, win_nums);

        System.out.println(Arrays.toString(solution));

    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int correctCnt = 0;
        Map<Integer, Integer> lotto = new HashMap<>();

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            lotto.put(lottos[i], 0);
        }

        if (lotto.size() == 0) {
            answer[0] = 1;
            answer[1] = 6;
            return answer;
        }

        for (int i = 0; i < win_nums.length; i++) {
            if (lotto.containsKey(win_nums[i])) {
                correctCnt++;
            }
        }
        answer[0] = getRanking(correctCnt + zeroCnt);
        answer[1] = getRanking(correctCnt);

        return answer;
    }

    static int getRanking(int n) {
        if (n == 6) {
            return 1;
        } else if (n == 5) {
            return 2;
        } else if (n == 4) {
            return 3;
        } else if (n == 3) {
            return 4;
        } else if (n == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}
