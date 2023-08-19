package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snow = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snow);

        int arraySize = (N * (N - 1)) / 2;
        SnowMan[] snowCombi = new SnowMan[arraySize];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                snowCombi[idx++] = new SnowMan(j, i, snow[i] + snow[j]);
            }
        }

        Arrays.sort(snowCombi);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < snowCombi.length - 1; i++) {
            for (int j = i + 1; j < snowCombi.length; j++) {
                if (snowCombi[i].bottomIdx != snowCombi[j].bottomIdx && snowCombi[i].topIdx != snowCombi[j].topIdx && snowCombi[i].topIdx != snowCombi[j].bottomIdx && snowCombi[i].bottomIdx != snowCombi[j].topIdx) {
                    minDiff = Math.min(minDiff, Math.abs(snowCombi[j].totalDim - snowCombi[i].totalDim));
                    break;
                }
            }
        }

        System.out.println(minDiff);

    }

    static class SnowMan implements Comparable<SnowMan>{
        int bottomIdx;
        int topIdx;
        int totalDim;

        public SnowMan(int bottomIdx, int topIdx, int totalDim) {
            this.bottomIdx = bottomIdx;
            this.topIdx = topIdx;
            this.totalDim = totalDim;
        }

        @Override
        public int compareTo(SnowMan o) {
            return totalDim - o.totalDim;
        }
    }
}
