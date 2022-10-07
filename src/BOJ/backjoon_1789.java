package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int cnt = 0;
        for (long i = 1; ; i++) {
            if (sum > S) {
                break;
            }
            sum += i;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
