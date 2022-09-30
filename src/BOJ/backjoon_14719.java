package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] rains = new int[W];
        for (int i = 0; i < W; i++) {
            rains[i] = Integer.parseInt(st.nextToken());
        }

        int totalRainAmount = 0;
        for (int i = 1; i < W; i++) {

            int leftMax = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (rains[j] > rains[i]) {
                    leftMax = Math.max(leftMax, rains[j]);
                }
            }

            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < W; j++) {
                if (rains[j] > rains[i]) {
                    rightMax = Math.max(rightMax, rains[j]);
                }
            }

            int rainAmont = Math.min(leftMax, rightMax);
            if (rainAmont == Integer.MIN_VALUE) {
                continue;
            }
            totalRainAmount += rainAmont - rains[i];
        }

        System.out.println(totalRainAmount);
    }
}
