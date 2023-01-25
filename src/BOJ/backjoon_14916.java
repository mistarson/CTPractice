package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] minCnt = new int[100000 + 1];
        Arrays.fill(minCnt, 50001);
        minCnt[2] = 1;
        minCnt[4] = 2;
        minCnt[5] = 1;
        for (int i = 6; i <= n; i++) {
            minCnt[i] = Math.min(minCnt[i - 2] + 1, minCnt[i - 5] + 1);
        }

        if (minCnt[n] == 50001) {
            System.out.println(-1);
        } else System.out.println(minCnt[n]);
    }
}
