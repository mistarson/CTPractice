package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_2908 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int count = st.countTokens();
        StringBuffer sb = new StringBuffer();
        int number[] = new int[count];

        for (int i = 0; i < count ; i++) {
            sb.append(st.nextToken());
            number [i] = Integer.parseInt(sb.reverse().toString());
            sb.delete(0, sb.length());
        }
        bw.write(String.valueOf(Math.max(number[0],number[1])));
        bw.flush();

    }
}
