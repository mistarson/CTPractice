package programmers.자물쇠와열쇠;

public class Solution {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean solution = solution(key, lock);
        System.out.println(solution);
    }

    static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length;
        int N = lock.length;

        int emptyCnt = 0;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    emptyCnt++;
                }
            }
        }

        int extendLockLength = N + (M - 1) * 2;
        int[][] extendLock = new int[extendLockLength][extendLockLength];

        // 확장 자물쇠 -1로 초기화
        for (int i = 0; i < extendLockLength; i++) {
            for (int j = 0; j < extendLockLength; j++) {
                extendLock[i][j] = -1;
            }
        }

        // 확장 자물쇠 안에 실제 자물쇠 넣기
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                extendLock[i][j] = lock[i - (M - 1)][j - (M - 1)];
            }
        }

        if (isPossible(emptyCnt, extendLockLength, M, extendLock, key)) {
            answer = true;
        }

        return answer;
    }

    static void clockRotate(int[][] key, int M) {

        int[][] temp = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = key[M - 1 - j][i];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                key[i][j] = temp[i][j];
            }
        }

    }

    static boolean isPossible(int emptyCnt, int extendLockLength, int M, int[][] extendLock, int[][] key) {
        int clockCnt = 0;
        while (clockCnt < 4) {
            for (int i = 0; i <= extendLockLength - M; i++) {
                for (int j = 0; j < extendLockLength - M; j++) {

                    int correctCnt = 0;
                    loop:
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {

                            // 열쇠 돌기와 자물쇠 돌기끼리 부딫힌 경우
                            if (extendLock[i + k][j + l] == 1 && key[k][l] == 1) {
                                break loop;
                            }

                            // 자물쇠 빈곳에 열쇠 돌기가 맞으면
                            if (extendLock[i + k][j + l] == 0 && key[k][l] == 1) {
                                correctCnt++;
                            }

                        }
                    }
                    if (correctCnt == emptyCnt) {
                        return true;
                    }
                }
            }
            clockRotate(key, M);
            clockCnt++;
        }
        return false;
    }
}
