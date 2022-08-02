package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] cards;
    static int[] bestChoice;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N + 1];
        bestChoice = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            bestChoice[i] = cards[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j > 0; j--) {
                bestChoice[i] = Math.max(bestChoice[i], bestChoice[i - j] + bestChoice[j]);
            }
        }

        System.out.println(bestChoice[N]);

    }
}
