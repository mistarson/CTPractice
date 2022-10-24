package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_15558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] left = new int[N + 1];
        left[0] = 0;
        String leftStr = br.readLine();
        for (int i = 0; i < N; i++) {
            left[i + 1] = leftStr.charAt(i) - '0';
        }
        int[] right = new int[N + 1];
        right[0] = 0;
        String rightStr = br.readLine();
        for (int i = 0; i < N; i++) {
            right[i + 1] = rightStr.charAt(i) - '0';
        }

        boolean[][] isVisited = new boolean[2][N + 1];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 1, 1));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            switch (current.leftOrRight) {
                case 0:
                    if (current.position + 1 > N) {
                        System.out.println(1);
                        return;
                    } else if (left[current.position + 1] == 1) {
                        if (!isVisited[0][current.position + 1]) {
                            isVisited[0][current.position + 1] = true;
                            queue.add(new Position(0, current.position + 1, current.sequence + 1));
                        }
                    }

                    if (current.position - 1 > current.sequence && left[current.position - 1] == 1) {
                        if (!isVisited[0][current.position - 1]) {
                            isVisited[0][current.position - 1] = true;
                            queue.add(new Position(0, current.position - 1, current.sequence + 1));
                        }
                    }

                    if (current.position + k > N) {
                        System.out.println(1);
                        return;
                    } else if (right[current.position + k] == 1) {
                        if (!isVisited[1][current.position + k]) {
                            isVisited[1][current.position + k] = true;
                            queue.add(new Position(1, current.position + k, current.sequence + 1));
                        }
                    }
                    break;
                case 1:
                    if (current.position + 1 > N) {
                        System.out.println(1);
                        return;
                    } else if (right[current.position + 1] == 1) {
                        if (!isVisited[1][current.position + 1]) {
                            isVisited[1][current.position + 1] = true;
                            queue.add(new Position(1, current.position + 1, current.sequence + 1));
                        }
                    }

                    if (current.position - 1 > current.sequence && right[current.position - 1] == 1) {
                        if (!isVisited[1][current.position - 1]) {
                            isVisited[1][current.position - 1] = true;
                            queue.add(new Position(1, current.position - 1, current.sequence + 1));
                        }
                    }

                    if (current.position + k > N) {
                        System.out.println(1);
                        return;
                    } else if (left[current.position + k] == 1) {
                        if (!isVisited[0][current.position + k]) {
                            isVisited[0][current.position + k] = true;
                            queue.add(new Position(0, current.position + k, current.sequence + 1));
                        }
                    }
                    break;
            }
        }

        System.out.println(0);
    }

    static class Position {
        int leftOrRight;
        int position;
        int sequence;

        public Position(int leftOrRight, int position, int sequence) {
            this.leftOrRight = leftOrRight;
            this.position = position;
            this.sequence = sequence;
        }
    }
}
