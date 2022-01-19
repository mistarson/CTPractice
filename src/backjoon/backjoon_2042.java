package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_2042 {

    static long[] arr;
    static long[] result;
    static int S = 1;
    static int count =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        int problemCnt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        arr = new long[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        while (count > S) {
            S *= 2;
        }

        result = new long[S * 2];
        result[0] = 0;

        InitTD(1, S, 1);

        for (int i = 0; i < problemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long index = Long.parseLong(st.nextToken());
                long transNumber = Long.parseLong(st.nextToken());
                long diff = transNumber - arr[(int) (index - 1)];
                arr[(int) (index - 1)] = transNumber;

                UpdateTD(1,S,1,index, diff);


            } else {
                long query = QueryTD(1, S, 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                bw.write(query+"\n");
            }

        }

        bw.flush();

    }

    static long InitTD(int left, int right, int node) {

        if (left <= count) {
            if (left != right) {
                result[node] = InitTD(left, (left + right) / 2, node * 2) + InitTD((left + right) / 2 + 1, right, node * 2 + 1);
                return result[node];
            } else {
                result[node] = arr[node - S];
                return result[node];
            }
        } else return 0;

    }

    static long QueryTD(int left, int right, int node, int queryLeft, int queryRight) {

        if (left >= queryLeft && right <= queryRight) {
            return result[node];
        } else if (right < queryLeft || left > queryRight) {
            return 0;
        } else {
            return QueryTD(left, (left + right) / 2, node * 2, queryLeft, queryRight)
                    + QueryTD((left + right) / 2 + 1, right, node * 2 + 1, queryLeft, queryRight);
        }

    }

    static void UpdateTD(int left, int right, int node, long target, long diff) {

        if (left <= target && right >= target) {
            result[node] += diff;
            if(left != right) {
                if (result[node * 2] != 0) {
                    UpdateTD(left, (left + right) / 2, node * 2, target, diff);
                }
                if (result[node * 2 + 1] != 0) {
                    UpdateTD((left + right) / 2 + 1, right, node * 2 + 1, target, diff);
                }
            }
        }
    }


}
