package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (true) {
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
                break;
            }

            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");

        }

        System.out.println(sb.toString());
    }
}
