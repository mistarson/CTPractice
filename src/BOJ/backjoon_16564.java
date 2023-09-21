package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            int level = Integer.parseInt(br.readLine());
            arr[i] = level;
        }

        Arrays.sort(arr);

        long left = arr[0];
        long right = arr[arr.length - 1] + K;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid, arr, K)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    static boolean isPossible(long mid, long[] arr, int K) {
        for (int i = 0; i < arr.length; i++) {
            if (K + arr[i] < mid) {
                return false;
            }else{
                if (arr[i] < mid) {
                    K -= (int) (mid - arr[i]);
                }
            }
        }

        return true;
    }
}
