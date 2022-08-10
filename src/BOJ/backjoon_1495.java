package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_1495 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S, M;
    static int[] volumes;
    static Set<Integer>[] possiblePlay;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        volumes = new int[N];
        possiblePlay = new HashSet[N + 1];

        for (int i = 0; i <= N; i++) {
            possiblePlay[i] = new HashSet<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        possiblePlay[0].add(S);

        for (int i = 0; i < N; i++) {
            for (int volume : possiblePlay[i]) {
                int expectPlusVolume = volume + volumes[i];
                if (expectPlusVolume >= 0 && expectPlusVolume <= M) {
                    possiblePlay[i + 1].add(expectPlusVolume);
                }
                int expectMinusVolume = volume - volumes[i];
                if (expectMinusVolume >= 0 && expectMinusVolume <= M) {
                    possiblePlay[i + 1].add(expectMinusVolume);
                }
            }
        }

        Set<Integer> finalStage = possiblePlay[N];
        if (finalStage.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int maxVolume = Integer.MIN_VALUE;
        for (Integer volume : finalStage) {
            maxVolume = Math.max(maxVolume, volume);
        }

        System.out.println(maxVolume);

    }

}
