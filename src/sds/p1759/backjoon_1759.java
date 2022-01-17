package sds.p1759;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class backjoon_1759 {
    static int L, C;
    static char data[];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/sds/p1759/input.txt"));

        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        data = new char[C];

        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);

        dfs(0,0,0,-1,"");

        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
        }

    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        // 1. 체크인 - 생략 가능
        // 2. 목적지인가? 길이(L) + 자음, 모음 개수
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        } else {
            // 3. 연결된 곳을 순회 - 나보다 높은 알파벳
            for (int nextIndex = current + 1; nextIndex < data.length; nextIndex++) {
                char nextData = data[nextIndex];
                // 4. 갈 수 있는가? - 생략 가능
                if (nextData == 'a' || nextData == 'e' || nextData == 'i' || nextData == 'o' || nextData == 'u') {
                    // 5. 간다 - dfs(next) -> 자음, 모음
                    dfs(length + 1, ja, mo + 1, nextIndex, pwd + nextData);
                } else {
                    // 5. 간다 - dfs(next) -> 자음, 모음
                    dfs(length + 1, ja + 1, mo, nextIndex, pwd + nextData);
                }

            }

        }

        // 6. 체크아웃 - 생략가능
    }
}
