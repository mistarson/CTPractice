package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_2033 {

    static int N, M;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[N + 1];
        int low = 0, high = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        sum = sequence[0];
        int count = 0;
        while (true) {

            if (high == N) {
                break;
            }

            if (sum < M) {
                sum+=sequence[++high];
            } else if (sum > M) {
                sum -= sequence[low++];
            } else {
                count++;
                sum -= sequence[low++];
            }

        }

        bw.write(count + "");
        bw.flush();
    }

}
