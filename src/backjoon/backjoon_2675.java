package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class backjoon_2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        int totalCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalCount; i++) {

            String S = br.readLine();
            StringTokenizer st = new StringTokenizer(S);

            int count = Integer.parseInt(st.nextToken());

            String str = st.nextToken();
            String P = "";

            for (int j = 0; j < str.length(); j++) {
                for (int z = 0; z < count; z++) {
                    P += String.valueOf(str.charAt(j));
                }
            }
            bw.write(P);
            bw.newLine();
        }
        bw.flush();

    }
}
