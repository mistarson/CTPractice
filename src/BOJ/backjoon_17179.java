package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_17179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] cut = new int[M + 1];
        for (int i = 0; i < M; i++) {
            cut[i] = Integer.parseInt(br.readLine());
        }
        cut[M] = L;

        for (int i = 0; i < N; i++) {
            int result = 0;
            int Q = Integer.parseInt(br.readLine());
            int low = 0;
            int high = L;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (cutByMidLength(mid, Q, cut)) {
                    high = mid - 1;
                } else low = mid + 1;
            }

            answer.append(high).append("\n");
        }

        System.out.println(answer);

    }

    static boolean cutByMidLength(int mid, int Q, int[] cut) {
        int prev = 0;
        for (int i = 0; i < cut.length; i++) {
            if (cut[i] - prev >= mid) {
                Q--;
                prev = cut[i];
            }
        }

        return Q >= 0;
    }
}
