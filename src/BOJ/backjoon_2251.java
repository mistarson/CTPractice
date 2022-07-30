package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class backjoon_2251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] waterBottles = new int[3 + 1];
    static Set<Integer> answer = new TreeSet<>();
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 3; i++) {
            waterBottles[i] = Integer.parseInt(st.nextToken());
        }

        isVisited = new boolean[waterBottles[1] + 1][waterBottles[2] + 1];

        findZeroAWaterBottle(0, 0, waterBottles[3]);

        for (Integer water : answer) {
            System.out.print(water + " ");
        }


    }

    static void findZeroAWaterBottle(int A, int B, int C) {
        if (isVisited[A][B]) {
            return;
        }

        if (A == 0) {
            answer.add(C);
        }

        isVisited[A][B] = true;

        // A -> B로 옮김
        if (A + B > waterBottles[2]) {
            findZeroAWaterBottle((A + B) - waterBottles[2], waterBottles[2], C);
        } else {
            findZeroAWaterBottle(0, A + B, C);
        }

        // B -> A로 옮김
        if (B + A > waterBottles[1]) {
            findZeroAWaterBottle(waterBottles[1], (B + A) - waterBottles[1], C);
        } else {
            findZeroAWaterBottle(B + A, 0, C);
        }

        // A -> C로 옮김
        if (A + C > waterBottles[3]) {
            findZeroAWaterBottle((A + C) - waterBottles[3], B, waterBottles[3]);
        } else {
            findZeroAWaterBottle(0, B, A + C);
        }

        // C -> A로 옮김
        if (C + A > waterBottles[1]) {
            findZeroAWaterBottle(waterBottles[1], B, (C + A) - waterBottles[1]);
        } else {
            findZeroAWaterBottle(C + A, B, 0);
        }

        // B -> C로 옮김
        if (B + C > waterBottles[3]) {
            findZeroAWaterBottle(A, (B + C) - waterBottles[3], waterBottles[3]);
        } else {
            findZeroAWaterBottle(A, 0, B + C);
        }

        // C -> B로 옮김
        if (C + B > waterBottles[2]) {
            findZeroAWaterBottle(A, waterBottles[2], (C + B) - waterBottles[2]);
        } else {
            findZeroAWaterBottle(A, C + B, 0);
        }
    }


}
