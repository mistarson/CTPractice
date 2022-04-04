package sds.p2003;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;
        int low = 0, high = 0;
        int cnt = 0, sum = 0;
        int num[];

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        sum = num[0];
        while (true) {

            // sum == M -> 답 low++
            if (sum == M) {
                cnt++;
                sum -= num[low++];
            }

            // sum > M -> low++
            else if (sum > M) {
                sum -= num[low++];
            }
            // sum < M -> high++
            else {
                sum += num[++high];
            }

            if (high == N) {
                break;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();

    }
}
