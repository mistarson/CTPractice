package devmatching;

public class Solution3 {
    static long answer = 0;

    public static void main(String[] args) {
        long solution = new Solution3().solution(4);
        System.out.println(solution);
    }

    public long solution(int k) {
        int[] need = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        getTotalCase(0, k, need);
        return answer;
    }

    static void getTotalCase(int cnt, int k, int[] need) {

        if (cnt == k) {
            answer++;
        }

        for (int i = 0; i <= 9; i++) {
            if (cnt == 0 && i == 0) {
                continue;
            }

            if (cnt + need[i] <= k) {
                getTotalCase(cnt + need[i], k, need);
            }
        }

    }
}
