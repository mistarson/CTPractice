package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_19699 {
    static final int MAX_WEIGHT = 1000;
    static Set<Integer> primeList = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[(M * MAX_WEIGHT) + 1];
        initPrimeArr(isNotPrime);

        int[] weightArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weightArr[i] = Integer.parseInt(st.nextToken());
        }

        findAbleCase(weightArr, isNotPrime, M, 0, 0, 0);


        if (primeList.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : primeList) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }

    private static void findAbleCase(int[] weightArr, boolean[] isNotPrime, int m, int depth, int sum, int start) {
        if (depth == m) {
            if (!isNotPrime[sum]) {
                primeList.add(sum);
            }
            return;
        }

        for (int i = start; i < weightArr.length; i++) {
            findAbleCase(weightArr, isNotPrime, m, depth + 1, sum + weightArr[i], i + 1);
        }
    }

    private static void initPrimeArr(boolean[] isNotPrime) {

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < isNotPrime.length; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
