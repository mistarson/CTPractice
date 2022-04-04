package BOJ;

import java.io.*;

public class backjoon_10809 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int[] result = new int[26];

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = (int) (c - 97);
            if (result[index] != -1) {
                continue;
            }
            result[index] = i;
        }

        int count = 0;

        for (int i : result) {
            if (count == 26) {
                System.out.print(i);
                break;
            }
            System.out.print(i+" ");
            count++;
        }



    }
}
