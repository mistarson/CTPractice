package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_1446 {
    static final int MAX_D = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Shortcut[] list = new Shortcut[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list[i] = new Shortcut(start, end, distance);
        }

        Arrays.sort(list);

        int[] dp = new int[MAX_D + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < list.length; i++) {
            Shortcut shortcut = list[i];
            if (shortcut.end > D) {
                continue;
            }
            dp[shortcut.end] = Math.min(dp[shortcut.end], dp[shortcut.start] + shortcut.distance);
            dp[D] = Math.min(dp[D], dp[shortcut.end] + D - shortcut.end);

            for (int j = i + 1; j < list.length; j++) {
                Shortcut nextShortcut = list[j];
                if (nextShortcut.start > shortcut.end) {
                    dp[nextShortcut.start] =
                            Math.min(dp[nextShortcut.start], dp[shortcut.end] + nextShortcut.start - shortcut.end);
                }
            }

        }

        System.out.println(dp[D]);

    }

    static class Shortcut implements Comparable<Shortcut>{
        int start;
        int end;
        int distance;

        public Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Shortcut o) {
            return start - o.start;
        }
    }
}
