package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_10025 {
    static final int ARRAY_SIZE = 1000000;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[ARRAY_SIZE + 1];
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
            totalSum += g;
        }

        if (K >= ARRAY_SIZE / 2) {
            System.out.println(totalSum);
            System.exit(0);
        }

        // 슬라이딩 윈도우 생성
        int sum = 0;
        for (int i = 1; i < (K + 1) * 2; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        // 슬라이딩 윈도우를 통한 탐색 시작
        for (int i = K + 2; i < arr.length - K; i++) {
            sum -= arr[i - K - 1];
            sum += arr[i + K];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
