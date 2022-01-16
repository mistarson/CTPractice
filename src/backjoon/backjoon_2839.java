package backjoon;

import java.io.*;

public class backjoon_2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (true) {
            if (N % 5 == 0) {
                bw.write(String.valueOf(N / 5 + cnt));
                break;
            } else if (N < 0) {
                bw.write(String.valueOf(-1));
                break;
            }
            N = N - 3;
            cnt++;
        }
        bw.flush();
    }
}
