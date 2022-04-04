package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            sb.append(PeopleNumber(K, N)).append("\n");
        }
        System.out.print(sb);
    }

    static int PeopleNumber(int K, int N) {
        if (N == 0)
            return 0;
        else if
        (K == 0) return N;
        else
            return PeopleNumber(K, N - 1) + PeopleNumber(K - 1, N);
    }
}

