package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class backjoon_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i == j) {
                    continue;
                }
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }

        int cnt = 0;
        int left = 0;
        int right = 0;
        int sum = primeList.get(0);
        while (left <= right) {
            if (sum > N) {
                sum -= primeList.get(left++);
            } else if (sum < N) {
                if (right + 1 == primeList.size()) {
                    break;
                }
                sum += primeList.get(++right);
            } else {
                cnt++;
                if (right + 1 == primeList.size()) {
                    break;
                }
                sum += primeList.get(++right);
            }
        }

        System.out.println(cnt);

    }


}
