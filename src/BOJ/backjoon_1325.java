package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_1325 {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
        }

        int maxConnection = 0;
        int[] computerArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            computerArr[i] = bfs(i);
            maxConnection = Math.max(maxConnection, computerArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < computerArr.length; i++) {
            if (computerArr[i] == maxConnection) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }

    static int bfs(int startIdx) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIdx);
        isVisited[startIdx] = true;
        int connectionCnt = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            List<Integer> list = graph.get(current);
            for (Integer next : list) {
                if (!isVisited[next]) {
                    queue.add(next);
                    isVisited[next] = true;
                    connectionCnt++;
                }
            }
        }

        return connectionCnt;
    }
}