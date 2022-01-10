package backjoon;

import java.io.*;

public class backjoon_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalCnt = Integer.parseInt(br.readLine());
        int wordCnt = 0;

        for (int i = 0; i < totalCnt; i++) {
        String word = br.readLine();
            if (word.length() < 3) {
                wordCnt++;
                continue;
            }
        loop:
        for (int j = 0; j < word.length() - 1; j++) {
            for (int z = 1; z < word.length(); z++) {
                char c1 = word.charAt(j);
                char c2 = word.charAt(z);
                if (j == word.length() - 2 && z == word.length() - 1) {
                    wordCnt++;
                }
                if (c1 == c2 && z - j == 1) {
                    j++;
                    continue;
                } else if (c1 == c2 && z - j >= 2) {
                    break loop;
                }


            }
        }
        }
        bw.write(String.valueOf(wordCnt));
        bw.flush();
    }
}
