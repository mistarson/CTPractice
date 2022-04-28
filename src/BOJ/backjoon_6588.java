package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class backjoon_6588 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();

        int maxNumber = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            maxNumber = Math.max(maxNumber, n);
            list.add(n);
        }

        boolean[] isNotPrime = new boolean[maxNumber + 1];

        for (int i = 2; i <= Math.sqrt(maxNumber); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= maxNumber; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = 0; i < list.size(); i++) {

            boolean flag = false;
            Integer n = list.get(i);

            for (int j = 3; j <= n / 2; j++) {
                if (!isNotPrime[j] && !isNotPrime[n - j]) {
                    flag = true;
                    sb.append(n + " = " + j + " + " + (n-j)).append("\n");
                    break;
                }
            }
            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.");
            }

        }

        System.out.println(sb.toString());

    }

}
