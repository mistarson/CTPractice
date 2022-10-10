package programmers.피로도;

public class Solution {
    static int maxVisitDungeon = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = new Solution().solution(k, dungeons);
        System.out.println(solution);
    }

    public int solution(int k, int[][] dungeons) {

        boolean[] isVisited = new boolean[dungeons.length];
        getMaxVisitDungeon(0, k, dungeons, isVisited);

        return maxVisitDungeon;
    }

    static void getMaxVisitDungeon(int cnt, int currentK, int[][] dungeons, boolean[] isVisited) {

        maxVisitDungeon = Math.max(maxVisitDungeon, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && currentK >= dungeons[i][0]) {
                isVisited[i] = true;
                getMaxVisitDungeon(cnt + 1, currentK - dungeons[i][1], dungeons, isVisited);
                isVisited[i] = false;
            }
        }
    }

}
