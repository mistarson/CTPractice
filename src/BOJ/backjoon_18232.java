package BOJ;

import java.io.*;
import java.util.*;

public class backjoon_18232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[N + 1];

        List<List<Integer>> teleport = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            teleport.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            teleport.get(x).add(y);
            teleport.get(y).add(x);
        }

        int answer = 0;
        Queue<Position> queue = new LinkedList<>();
        isVisited[S] = true;
        queue.add(new Position(S, 0));
        while (!queue.isEmpty()) {

            Position position = queue.poll();

            if (position.node == E) {
                answer = position.time;
                break;
            }

            for (int other : teleport.get(position.node)) {
                if (!isVisited[other]) {
                    isVisited[other] = true;
                    queue.add(new Position(other, position.time + 1));
                }
            }

            if (position.node == 1) {
                if (!isVisited[2]) {
                    isVisited[2] = true;
                    queue.add(new Position(2, position.time + 1));
                }
            } else if (position.node == N) {
                if (!isVisited[N - 1]) {
                    isVisited[N - 1] = true;
                    queue.add(new Position(N - 1, position.time + 1));
                }
            } else {
                if (!isVisited[position.node - 1]) {
                    isVisited[position.node - 1] = true;
                    queue.add(new Position(position.node - 1, position.time + 1));
                }
                if (!isVisited[position.node + 1]) {
                    isVisited[position.node + 1] = true;
                    queue.add(new Position(position.node + 1, position.time + 1));
                }
            }
        }

        System.out.println(answer);

    }

    static class Position {
        int node;
        int time;

        public Position(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}