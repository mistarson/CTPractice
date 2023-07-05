package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_17451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] planets = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long maxVelocity = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            planets[i] = Long.parseLong(st.nextToken());
            if (maxVelocity < planets[i]) {
                maxVelocity = planets[i];
                maxIdx = i;
            }
        }

        long minVelocity = maxVelocity;
        for (int i = maxIdx; i >= 0; i--) {
            if (planets[i] % minVelocity != 0) {
                minVelocity = ((minVelocity / planets[i]) + 1) * planets[i];
            }
        }

        System.out.println(minVelocity);


    }

}
