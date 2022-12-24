package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < files[0].length(); i++) {
            boolean isAllSame = true;
            char c = files[0].charAt(i);
            for (int j = 1; j < N; j++) {
                if (files[j].charAt(i) != c) {
                    isAllSame = false;
                }
            }

            if (isAllSame) {
                answer.append(c);
            } else answer.append('?');
        }

        System.out.println(answer);

    }
}