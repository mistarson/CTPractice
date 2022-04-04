package sds.p14476;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        int[] gcdLtoR = new int[count];
        int[] gcdRtoL = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        gcdLtoR[0] = arr[0];
        gcdRtoL[count - 1] = arr[count - 1];
        for (int i = 1; i < count; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i - 1], arr[i]);
        }

        for (int i = count - 2; i >= 0; i--) {
            gcdRtoL[i] = gcd(gcdRtoL[i + 1], arr[i]);
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < count; i++) {
            int gcd = 0;

            if (i == 0) {
                gcd = gcdRtoL[1];
            } else if (i == count - 1) {
                gcd = gcdLtoR[count - 2];
            } else {
                gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]);
            }

            if (arr[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }
        if (max == 0) {
            bw.write("-1");
        } else {
            bw.write(max + " " +arr[maxIndex]);
        }
        bw.flush();




    }

    static int gcd(int a, int b) {
        if (b != 0) {
            int r = a % b;
            return gcd(b, r);
        } else {
            return a;
        }


    }
}
