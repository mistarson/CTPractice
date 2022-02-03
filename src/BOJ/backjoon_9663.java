package BOJ;

import java.io.*;

//TODO 나중에 한번 더 풀 어 볼 것
public class backjoon_9663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] isused1 = new boolean[4];
    static boolean[] isused2 = new boolean[7];
    static boolean[] isused3 = new boolean[7];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(count);

    }

    static void dfs(int cur) {
        if (cur == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isused1[i] || isused2[i + cur] || isused3[cur - i + N - 1]) {
                continue;
            }
            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[cur - i + N - 1] = true;
            dfs(cur + 1);
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[cur - i + N - 1] = false;
        }
    }
}
