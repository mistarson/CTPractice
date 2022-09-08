package programmers.양궁대회;

import java.util.Arrays;

public class Solution {
    static int maxDiffScore = -1;

    public static void main(String[] args) {
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] solution = new Solution().solution(n, info);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] rionInfo = new int[11];
        getMaxScore(0, rionInfo, n, info, 0, answer);

        boolean allZero = true;
        for (int i = 0; i < 11; i++) {
            if (answer[i] != 0) {
                allZero = false;
            }
        }
        if (allZero) {
            return new int[]{-1};
        }

        return answer;
    }

    static void getMaxScore(int arrowCnt, int[] rionInfo, int n, int[] info, int start, int[] answer) {

        if (arrowCnt > n) {
            return;
        }

        if (arrowCnt == n) {
            int diffScore = getDiffScore(info, rionInfo);
            if (maxDiffScore <= diffScore) {
                if (manyMinArrow(rionInfo, answer)) {
                    maxDiffScore = diffScore;
                    saveAnswer(rionInfo, answer);
                }
            }
            return;
        }

        for (int i = start; i < 11; i++) {
            if (i == 10 && n - arrowCnt > 0) {
                rionInfo[i] = n - arrowCnt;
                getMaxScore(arrowCnt + n - arrowCnt, rionInfo, n, info, i + 1, answer);
                rionInfo[i] = 0;
                return;
            }
            rionInfo[i] = info[i] + 1;
            getMaxScore(arrowCnt + info[i] + 1, rionInfo, n, info, i + 1, answer);
            rionInfo[i] = 0;
            getMaxScore(arrowCnt, rionInfo, n, info, i + 1, answer);
        }
    }

    static int getDiffScore(int[] info, int[] rionInfo) {
        int apeachScore = 0;
        int rionScore = 0;
        for (int i = 0; i < 10; i++) {
            if (info[i] == 0 && rionInfo[i] == 0) {
                continue;
            }
            if (info[i] >= rionInfo[i]) {
                apeachScore += 10 - i;
            } else {
                rionScore += 10 - i;
            }
        }

        if (rionScore > apeachScore) {
            return rionScore - apeachScore;
        } else return -1;
    }

    static void saveAnswer(int[] rionInfo, int[] answer) {
        for (int i = 0; i < 11; i++) {
            answer[i] = rionInfo[i];
        }
    }

    static boolean manyMinArrow(int[] rionInfo, int[] answer) {

        boolean flag = false;
        for (int i = 10; i >= 0; i--) {
            if (rionInfo[i] == answer[i]) {
                continue;
            }
            if (rionInfo[i] > answer[i]) {
                flag = true;
            }
            break;
        }
        return flag;
    }
}
