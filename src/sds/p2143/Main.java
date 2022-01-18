package sds.p2143;

import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int M;
    static long a[], b[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/sds/p2143/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        b = new long[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        // subA 구하기
        for (int i = 0; i < N; i++) {
            long sum = a[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += a[j];
                subA.add(sum);
            }
        }

        // subB 구하기
        for (int i = 0; i < M; i++) {
            long sum = b[i];
            subB.add(sum);
            for (int j = i + 1; j < M; j++) {
                sum += b[j];
                subB.add(sum);
            }
        }

        //정렬하기
        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;

        while (ptA < subA.size() && ptB < subB.size()) {
            long currentA = subA.get(ptA);
            long target = T - currentA;

            // currentB == target -> subA, subB 같은 수 개수 체크 -> 답 구하기 (ptA+ ptB+)
            if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA) {
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }
                result += countA * countB;

            }

            // currentB > target -> ptB++
            else if (subB.get(ptB) > target) {
                ptB++;
            } else { // currentB < target -> ptA++
                ptA++;
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
