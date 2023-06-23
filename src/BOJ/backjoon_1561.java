package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] drivingTime = new int[M];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            drivingTime[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, drivingTime[i]);
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        long minTime = 1;
        long maxTime = N / M * max;
        while (minTime <= maxTime) {
            long mid = (maxTime + minTime) / 2;

            long sum = M;
            for (int i = 0; i < M; i++) {
                sum += mid / drivingTime[i];
            }

            if (sum >= N) {
                maxTime = mid - 1;
            } else minTime = mid + 1;
        }

        long minusSum = M;
        for (int i = 0; i < M; i++) {
            minusSum += (minTime - 1) / drivingTime[i];
        }

        for (int i = 0; i < M; i++) {
            if (minTime % drivingTime[i] == 0) {
                minusSum++;
            }
            if (minusSum == N) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
