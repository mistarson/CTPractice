package BOJ;

import java.io.*;

public class backjoon_1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int n = 1;
        int cnt = 0;

        while (true) {
            cnt += n;
            if (cnt >= X) {
                if (n % 2 == 0) {
                    bw.write(String.valueOf(X - cnt + n) + "/" + String.valueOf(cnt - X + 1));
                } else {
                    bw.write(String.valueOf(cnt - X + 1) + "/" + String.valueOf(X - cnt + n));
                }
                break;
            }
            n++;
        }
        bw.flush();
    }
}
