package BOJ;

import java.io.*;

public class backjoon_2292 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int bang = Integer.parseInt(br.readLine());
        int n = 1;
        if (bang > 1) {
            int temp = 1;
            while (bang > temp) {
                temp += 6 * n;
                n++;
            }
        }
        bw.write(String.valueOf(n));
        bw.flush();
    }
}
