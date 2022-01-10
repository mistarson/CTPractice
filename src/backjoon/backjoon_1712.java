package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_1712 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int cnt = 0;

        if (B < C ) {
            cnt = A / (C - B) + 1;
        } else cnt = -1;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
