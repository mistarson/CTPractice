package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class backjoon_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long cnt = 0;
        long[] sum = new long[N + 1];
        Map<Long, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {

            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            if (sum[i] == K) cnt++;

            if (map.containsKey(sum[i] - K)) cnt += map.get(sum[i] - K);

            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        System.out.println(cnt);

    }
}
