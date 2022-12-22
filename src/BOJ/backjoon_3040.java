package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hats = new int[9];
        int[] temp = new int[7];
        for (int i = 0; i < 9; i++) {
            hats[i] = Integer.parseInt(br.readLine());
        }

        findSevens(0, 0, hats, temp, 0);
    }

    static void findSevens(int sum, int size, int[] hats, int[] temp, int start) {
        if (size == 7) {
            if (sum == 100) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    sb.append(temp[i]).append("\n");
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            temp[size] = hats[i];
            findSevens(sum + hats[i], size + 1, hats, temp, i + 1);
            temp[size] = 0;
        }
    }
}
