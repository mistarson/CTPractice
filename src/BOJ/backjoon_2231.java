package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            String[] numSplit = String.valueOf(i).split("");
            for (int j = 0; j < numSplit.length; j++) {
                sum += Integer.parseInt(numSplit[j]);
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}
