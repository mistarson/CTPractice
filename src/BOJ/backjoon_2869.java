package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[2] > arr[0]) {

            int A = arr[2] - arr[0];
            int B = arr[0] - arr[1];

            if (A % B != 0) {
                bw.write(String.valueOf(A / B + 2));
            } else bw.write(String.valueOf(A / B + 1));


        } else bw.write(String.valueOf(1));


        bw.flush();
    }
}
