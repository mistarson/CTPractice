package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_16938 {
    static int N, L, R, X, cnt = 0;
    static int[] problem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제의 수
        L = Integer.parseInt(st.nextToken()); // 난이도는 L보다 크거나 같고
        R = Integer.parseInt(st.nextToken()); // R보다 작거나 같아야 한다.
        X = Integer.parseInt(st.nextToken()); // 가장 어려운 문제와 쉬운 문제의 차이는 X보다 크거나 같아야 한다.

        problem = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problem);

        List<Integer> findList = new ArrayList<>();
        findAbleCase(0, findList, -1, 0);

        System.out.println(cnt);
    }

    static void findAbleCase(int length, List<Integer> findList, int start, int sum) {

        if (length >= 2) {
            if (sum >= L && sum <= R) {
                int diff = findList.get(findList.size() - 1) - findList.get(0);
                if (diff >= X) {
                    cnt++;
                }
            }
        }

        for (int i = start + 1; i < problem.length; i++) {
            if (sum + problem[i] <= R) {
                findList.add(problem[i]);
                findAbleCase(length + 1, findList, i, sum + problem[i]);
                findList.remove(findList.size() - 1);
            }
        }
    }
}
