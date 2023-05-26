package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitNumber = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitNumber[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < X; i++) {
            max += visitNumber[i];
        }

        int start = 0;
        int end = X;
        int sum = max;
        int cnt = 1;
        for (int i = 0; i < N - X; i++) {
            sum -= visitNumber[start++];
            sum += visitNumber[end++];
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}
