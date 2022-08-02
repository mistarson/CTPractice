package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2011 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp;

    public static void main(String[] args) throws IOException {
        char[] password = br.readLine().toCharArray();

        if (password[0] == '0') {
            System.out.println(0);
            return;
        }

        int length = password.length;

        dp = new long[length];

        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int num = password[i] - '0';
            if (num >= 1 && num <= 9) {
                dp[i] = dp[i - 1] % 1000000;
            }

            int twoDigit = (password[i - 1] - '0') * 10 + num;
            if (twoDigit >= 10 && twoDigit <= 26) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2] % 1000000;
                }
            }
        }

        System.out.println(dp[length - 1] % 1000000);

    }
}
