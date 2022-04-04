package sds.p2243;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int MAX = 1000000;
    static int[] result = new int[(MAX + 1) * 4];
    static int S = 1;

    public static void main(String[] args) throws IOException {

        result[0] = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        while (S < MAX) {
            S = S * 2;
        }

        for (int i = 0; i < count; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 2) {
                int target = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());

                UpdateTD(1, S, 1, target, diff);

            } else {
                int n = Integer.parseInt(st.nextToken());
                int query = Query(1, S, 1, n);
                UpdateTD(1, S, 1, query, -1);
                bw.write(query+"\n");
            }
        }
        bw.flush();
    }

    static void UpdateTD(int left, int right, int node, long target, long diff) {

        if (left <= target && right >= target) {
            result[node] += diff;
            if (left != right) {
                    UpdateTD(left, (left + right) / 2, node * 2, target, diff);
                    UpdateTD((left + right) / 2 + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    static int Query(int left, int right, int node, int count) {
        // 1. Leaf에 도착햇을 때 -> 사탕 번호 반환
        if (left == right) {
            return left;
        }

        int mid = (left + right) / 2;
        // 2. 왼쪽이 > count -> 왼쪽으로 이동
        if (result[node * 2] >= count) {
            return Query(left, mid, node * 2, count);
        }
        // 3. 왼쪽 < count -> 오른쪽으로 이동
        else {
            return Query(mid + 1, right, node * 2 + 1, count - result[node * 2]);
        }
        //
    }


}
