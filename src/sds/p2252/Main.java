package sds.p2252;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> students = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N ; i++) {
            students.add(new ArrayList<>());
        }

        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students.get(a).add(b);
            indegree[b]++;

        }

        Queue<Integer> topolQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                topolQueue.add(i);
            }
        }

        while (!topolQueue.isEmpty()) {
            int student = topolQueue.poll();
            bw.write(student+" ");
            List<Integer> list = students.get(student);

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                indegree[temp]--;
                if (indegree[temp] == 0) {
                    topolQueue.add(temp);
                }
            }
        }
        bw.flush();
    }
}
