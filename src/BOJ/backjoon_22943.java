package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_22943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = getArraySizeByK(K);

        boolean[] isNotPrime = new boolean[size];
        List<Long> primeList = new ArrayList<>();
        boolean[] primeMulti = new boolean[size];

        //소수 구하기
        for (int i = 2; i < Math.sqrt(size); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < size; i++) {
            if (!isNotPrime[i]) {
                primeList.add((long)i);
            }
        }

        Set<Integer> primeSumSet = new HashSet<>();
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {
                // 서로 다른 두 개의 소수 합으로 나타낼 수 있는 경우
                if (i != j) {
                    primeSumSet.add((int)(primeList.get(i) + primeList.get(j)));
                }
                // 소수 끼리의 곱 (같은 숫자여도 됨)
                if (primeList.get(i) * primeList.get(j) < size) {
                    primeMulti[i * j] = true;
                }
            }
        }

        // M으로 나누어 떨어지지 않을때까지 나눈 수가 위 두 조건에 만족 하는지
        int cnt = 0;
        for (int i = 4; i < size; i++) {
            int extraNum = getExtraNum(i, M);
            if (primeMulti[extraNum]) {
                if (primeSumSet.contains(extraNum)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static int getArraySizeByK(int K) {
        if (K == 1) {
            return 10;
        } else if (K == 2) {
            return 100;
        } else if (K == 3) {
            return 1000;
        } else if (K == 4) {
            return 10000;
        } else return 100000;
    }

    public static int getExtraNum(int num, int M) {
        while (num % M == 0) {
            num /= M;
        }
        return num;
    }
}
