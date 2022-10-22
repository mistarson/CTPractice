package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_16401 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] snack = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int left = 1;
        int right = snack[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canReserve(mid, snack)) {
                left = mid + 1;
            } else right = mid - 1;
        }

        System.out.println(right);

    }

    static boolean canReserve(int mid, int[] snack) {

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (snack[i] >= mid) {
                cnt += snack[i] / mid;
            }
        }

        if (cnt >= M) {
            return true;
        } else return false;
    }
}
