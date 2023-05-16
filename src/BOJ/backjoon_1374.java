package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Class[] classes = new Class[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int classNum = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            classes[i] = new Class(startTime, endTime);
        }

        Arrays.sort(classes);

        int maxClass = 0;
        PriorityQueue<Class> pq = new PriorityQueue<>(new Comparator<Class>() {
            @Override
            public int compare(Class o1, Class o2) {
                return o1.endTime - o2.endTime;
            }
        });

        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                pq.add(classes[i]);
            } else {
                Class beforeClass = pq.peek();
                if (beforeClass.endTime <= classes[i].startTime) {
                    pq.poll();
                }
                pq.add(classes[i]);
            }
            maxClass = Math.max(maxClass, pq.size());
        }

        System.out.println(maxClass);


    }

    static class Class implements Comparable<Class> {
        int startTime;
        int endTime;

        public Class(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Class o) {
            return startTime - o.startTime;
        }
    }
}
