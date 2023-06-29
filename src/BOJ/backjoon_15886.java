package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_15886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] route = new char[N];
        boolean[] isVisited = new boolean[N];

        String routeStr = br.readLine();
        for (int i = 0; i < N; i++) {
            route[i] = routeStr.charAt(i);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int cycleCnt = 0;
            while (!isVisited[i]) {
                cycleCnt++;
                isVisited[i] = true;
                if (route[i] == 'E') {
                    i++;
                } else {
                    if (cycleCnt == 1) {
                        cnt--;
                    }
                    break;
                }
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
