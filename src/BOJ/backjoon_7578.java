package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjoon_7578 {

    static int N;
    static int S = 1;
    static int[] tree;
    static int[] node1;
    static HashMap<Integer, Integer> node2 = new HashMap<>();
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        while (S < N) {
            S *= 2;
        }

        node1 = new int[N + 1];
        tree = new int[S * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            node1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            node2.put(Integer.parseInt(st.nextToken()), i);
        }

        for (int i = 1; i <= N; i++) {
            int index = node2.get(node1[i]);
            count += getSum(1, S, 1, index + 1, N);
            update(1, S, 1, index);
        }
        bw.write(count + "");
        bw.flush();
    }

    static int getSum(int left, int right, int node, int queryLeft, int queryRight) {
        if (left > queryRight || right < queryLeft) {
            return 0;
        } else if (left >= queryLeft && right <= queryRight) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            return getSum(left, mid, node * 2, queryLeft, queryRight) + getSum(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
        }
    }

    static void update(int left, int right, int node, int target) {
        if (left <= target && right >= target) {
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target);
                update(mid + 1, right, node * 2 + 1, target);
            }
            tree[node]++;
        }
    }
}
