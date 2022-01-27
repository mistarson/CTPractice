package sds.p2579;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int count;
    static int[] score;
    static int[][] D;

    public static void main(String[] args) throws IOException {

        count = Integer.parseInt(br.readLine());
        score = new int[count + 1];
        D = new int[count + 1][3];
        for (int i = 1; i <= count; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        D[1][1] = score[1];

        for (int i = 2; i <= count; i++) {
            D[i][1] = Math.max(D[i][1], D[i - 2][1] + score[i]);
            D[i][1] = Math.max(D[i][1], D[i - 2][2] + score[i]);
            D[i][2] = Math.max(D[i][2], D[i - 1][1] + score[i]);
        }

        bw.write(Math.max(D[count][1],D[count][2]) + "\n");
        bw.flush();
        bw.close();

    }
}
