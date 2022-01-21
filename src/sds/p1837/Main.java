package sds.p1837;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MAX = 1000000;
    static boolean[] isNotPrime;
    static List<Integer> primes = new ArrayList<>();
    static char[] P;
    static int K;
    static int r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());
        isNotPrime = new boolean[MAX + 1];
        isNotPrime[1] = true;

        // 1~k까지 소수 구하기
        for (int i = 2; i < MAX + 1; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j < MAX + 1; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // P % 구한 소수 != 0
        for (int prime: primes) {
            if (prime >= K) {
                break;
            }
            if (checkIsBad(prime)) {
                System.out.println("BAD "+ prime);
                return;
            }
        }
        System.out.println("GOOD");


    }

    static boolean checkIsBad(int x) {
        int r = 0;
        for (int i = 0; i < P.length; i++) {
            r = (r * 10 + (P[i] - '0')) % x;
        }
        if (r == 0) {
            return true;
        } else {
            return false;
        }
    }

}
