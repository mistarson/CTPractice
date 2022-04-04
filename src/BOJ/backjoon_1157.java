package BOJ;

import java.io.*;
import java.util.Arrays;

public class backjoon_1157 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[26];
        String result;

        String word = br.readLine().toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            count[index]++;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {

            if (max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
        }

        result = String.valueOf((char) (maxIndex + 65));


        Arrays.sort(count);
        if (count[count.length - 1] == count[count.length - 2]) {
            result = "?";
        }

        bw.write(result);


        bw.flush();
    }
}
