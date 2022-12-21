package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] frequency = new int[10];
        for (int i = 1; i <= n; i++) {
            addFrequency(i, frequency);
        }

        System.out.println(frequency[d]);
    }

    static void addFrequency(int num, int[] frequency) {
        while (num != 0) {
            int digit = num % 10;
            frequency[digit]++;
            num /= 10;
        }
    }
}
