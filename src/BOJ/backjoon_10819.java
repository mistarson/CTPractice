package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_10819 {
    static int maxValue = 0;
    static int N;
    static int[] seq;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = new int[N];
        getMaxValue(0, temp);

        System.out.println(maxValue);

    }

    static void getMaxValue(int length, int[] temp) {
        if (length == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            maxValue = Math.max(maxValue, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp[length] = seq[i];
                getMaxValue(length + 1, temp);
                temp[length] = 0;
                isVisited[i] = false;
            }
        }

    }
}
