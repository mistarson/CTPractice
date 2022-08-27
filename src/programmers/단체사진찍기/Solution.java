package programmers.단체사진찍기;

public class Solution {
    static int ASCII_NUM = 128;
    static int FRIENDS_NUM = 8;
    static char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int cnt = 0;

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        int solution = new Solution().solution(n, data);
        System.out.println(solution);
        boolean acfnjmrt = isAlright("ACRFNJMT", data);
        System.out.println(acfnjmrt);
    }

    public int solution(int n, String[] data) {

        boolean[] isVisited = new boolean[ASCII_NUM];
        dfs(0, "", isVisited, data);

        return cnt;
    }

    static void dfs(int friendsCnt, String temp, boolean[] isVisited, String[] data) {
        if (friendsCnt == FRIENDS_NUM) {
            if (isAlright(temp, data)) {
                cnt++;
            }
            return;
        }
        for (int i = 0; i < FRIENDS_NUM; i++) {
            if (!isVisited[FRIENDS[i]]) {
                isVisited[FRIENDS[i]] = true;
                dfs(friendsCnt + 1, temp + FRIENDS[i], isVisited, data);
                isVisited[FRIENDS[i]] = false;
            }
        }
    }

    static boolean isAlright(String sequence, String[] data) {
        for (int i = 0; i < data.length; i++) {
            String condition = data[i];
            char friends = condition.charAt(0);
            char other = condition.charAt(2);
            char giho = condition.charAt(3);
            int num = Integer.parseInt(String.valueOf(condition.charAt(4)));

            int friendsIdx = 0;
            int otherIdx = 0;
            for (int j = 0; j < sequence.length(); j++) {
                if (sequence.charAt(j) == friends) {
                    friendsIdx = j;
                }
                if (sequence.charAt(j) == other) {
                    otherIdx = j;
                }
            }

            int distance = Math.abs(friendsIdx - otherIdx) - 1;

            switch (giho) {
                case '=':
                    if (distance != num) {
                        return false;
                    }
                    break;
                case '<':
                    if (distance >= num) {
                        return false;
                    }
                    break;
                case '>':
                    if (distance <= num) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
