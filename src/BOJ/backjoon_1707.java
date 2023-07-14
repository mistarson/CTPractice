package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                graph.add(new ArrayList<>());
            }

            // 그래프 초기화
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean isBipartiteGraph = true;
            int[] colors = new int[V + 1];
            for (int j = 1; j <= V; j++) {
                if (colors[j] != 0) {
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                colors[j] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();

                    List<Integer> nodeList = graph.get(node);
                    for (Integer nextNode : nodeList) {
                        if (colors[nextNode] == 0) {
                            queue.add(nextNode);
                            colors[nextNode] = convertColor(colors[node]);
                        } else {
                            if (colors[nextNode] == colors[node]) {
                                isBipartiteGraph = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (isBipartiteGraph) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");

        }

        System.out.println(sb);
    }

    static int convertColor(int color) {
        if (color == 1) {
            color = 2;
        }else color = 1;

        return color;
    }
}

