package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_20495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] minus = new int[N];
        int[] sum = new int[N];
        int[] sortedMinus = new int[N];
        int[] sortedSum = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            minus[i] = a - b;
            sortedMinus[i] = minus[i];
            sum[i] = a + b;
            sortedSum[i] = sum[i];
        }

        Arrays.sort(sortedMinus);
        Arrays.sort(sortedSum);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(sortedSum, minus[i])).append(" ");
            sb.append(upperBound(sortedMinus, sum[i])).append("\n");
        }

        System.out.println(sb);

    }

    static int lowerBound(int[] sortedSum, int value) {
        int left = 0;
        int right = sortedSum.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (sortedSum[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;

    }

    static int upperBound(int[] sortedMinus, int value) {
        int left = 0;
        int right = sortedMinus.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (sortedMinus[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left;

    }
}
