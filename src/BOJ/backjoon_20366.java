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

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowMan1 = snow[i] + snow[j];
                int left = 0;
                int right = N - 1;
                while (left < right) {
                    if (i == left) {
                        left++;
                    }
                    if (j == right) {
                        right--;
                    }

                    int snowMan2 = snow[left] + snow[right];
                    if (snowMan1 > snowMan2) {
                        minDiff = Math.min(minDiff, snowMan1 - snowMan2);
                        left++;
                    } else if (snowMan1 < snowMan2) {
                        minDiff = Math.min(minDiff, snowMan2 - snowMan1);
                        right--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(minDiff);
    }
}
