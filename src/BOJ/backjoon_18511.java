package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_18511 {
    static int maxNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K_size = Integer.parseInt(st.nextToken());
        int[] K = new int[K_size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K_size; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }

        getMaxNum("", N, K);

        System.out.println(maxNum);

    }

    static void getMaxNum(String temp, int N, int[] K) {

        if (!temp.equals("")) {
            int num = Integer.parseInt(temp);
            if (num <= N) {
                maxNum = Math.max(maxNum, num);
            } else return;
        }

        for (int i = 0; i < K.length; i++) {
            getMaxNum(temp + K[i], N, K);
        }
    }
}
