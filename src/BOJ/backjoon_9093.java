package BOJ;

import java.io.*;

public class backjoon_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                for (int k = split[j].length()-1; k >= 0; k--) {
                    bw.write(split[j].charAt(k));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}
