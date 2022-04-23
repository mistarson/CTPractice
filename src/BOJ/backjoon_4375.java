package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = null;

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int multiple = 1;
            int length = 1;

            while (true) {
                if (multiple % n == 0) {
                    break;
                }
                length++;
                multiple = ((multiple * 10) + 1) % n;
            }

            sb.append(length).append("\n");
        }

        System.out.println(sb.toString());
    }
}
