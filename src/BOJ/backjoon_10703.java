package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_10703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int maxMeteor = 0;
        int minMeteor = R;
        char[][] map = new char[R][S];
        int[] meteor = new int[S];
        int[] ground = new int[S];
        Arrays.fill(meteor, -1);
        Arrays.fill(ground, R);

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < S; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'X') {
                    meteor[j] = i;
                    maxMeteor = Math.max(maxMeteor, i);
                    minMeteor = Math.min(minMeteor, i);
                }
                if (map[i][j] == '#') {
                    ground[j] = Math.min(ground[j], i);
                }
            }
        }

        int minRow = Integer.MAX_VALUE;
        for (int i = 0; i < S; i++) {
            if (meteor[i] == -1) {
                continue;
            }
            minRow = Math.min(minRow, ground[i] - meteor[i]);
        }

        for (int i = maxMeteor; i >= minMeteor; i--) {
            for (int j = 0; j < S; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = '.';
                    map[i + minRow - 1][j] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(String.valueOf(map[i])).append("\n");
        }

        System.out.println(sb);
    }
}
