package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int count = st.countTokens();
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
