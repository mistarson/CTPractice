package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_15652 {

    static int N, M;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(0);

        for (String str : list) {
            bw.write(str+"\n");
        }

        bw.flush();
    }

    static void backTracking(int length) {
        if (length == M) {
            String str = convertStr(sb.toString());
            list.add(str);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (sb.length() == 0 ||Integer.parseInt(String.valueOf(sb.charAt(sb.length() - 1))) <= i) {
                sb.append(i);
                backTracking(length + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static String convertStr(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb2.append(str.charAt(i));
            if (i == str.length() - 1) {
                break;
            }
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
