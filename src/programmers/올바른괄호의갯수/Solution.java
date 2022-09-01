package programmers.올바른괄호의갯수;

public class Solution {

    static int cnt = 0;

    public static void main(String[] args) {

        int solution = solution(3);

        System.out.println(solution);

    }

    static int solution(int n) {

        dfs(0, 0, n);

        return cnt;
    }

    static void dfs(int open, int close, int n) {

        // 오픈괄호가 n을 넘지 않게
        if (open > n) {
            return;
        }

        // 첫괄호는 무조건 열린 괄호
        if (open == 0 && close == 1) {
            return;
        }

        // 열린괄호는 무조건 닫힘괄호보다 많게
        if (open < close) {
            return;
        }

        // 종료 조건
        if (open == n && close == n) {
            cnt++;
            return;
        }

        dfs(open + 1, close, n);
        dfs(open, close + 1, n);

    }
}
