package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class backjoon_1174 {
    static int N;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("", 10);
        Collections.sort(list, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else return o1.compareTo(o2);});

        if (N > list.size()) {
            System.out.println(-1);
        } else System.out.println(list.get(N - 1));


    }

    static void dfs(String temp, int before) {
        if (temp.length() > 0) {
            list.add(temp);
        }


        for (int i = before - 1; i >= 0; i--) {
            dfs(temp + i, i);
        }
    }
}
