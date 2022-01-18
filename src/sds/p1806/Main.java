package sds.p1806;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, S;
        int low = 0, high = 0;
        int sum = 0;
        int num[];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        sum = num[0];

        while (true) {

            // sum >= S -> 답 low++
            if (sum >= S) {
                min = Math.min(high - low +1 , min);
                sum -= num[low++];
            }

            // sum < S -> high++
            else {
                sum += num[++high];
            }

            if (high == N) {
                break;
            }
        }

        // 답이 없을 경우
        if (min == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(min));
        }

        bw.flush();
    }
}
