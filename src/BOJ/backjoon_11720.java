package BOJ;

import java.io.*;

public class backjoon_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        String numStr = br.readLine();

        for (int i = 0; i < numStr.length(); i++) {
            sum += numStr.charAt(i) - '0';
        }

        System.out.println(sum);


    }

}
