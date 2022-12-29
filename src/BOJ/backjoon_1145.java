package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1145 {
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[5];
        for (int i = 0; i < 5; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        findAtLeastMostMultiple(seq);

        System.out.println(minValue);
    }

    static void findAtLeastMostMultiple(int[] seq) {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int lcm = (seq[i] * seq[j]) / gcd(seq[i], seq[j]);
                    int finalLcm = (lcm * seq[k]) / gcd(lcm, seq[k]);
                    minValue = Math.min(minValue, finalLcm);
                }
            }
        }


    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
