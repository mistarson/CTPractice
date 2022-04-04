package BOJ;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class backjoon_1655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {

            int n = Integer.parseInt(br.readLine());
            
            // 크기가 같을 때, 최대한 maxHeap쪽에 넣어줘야 함
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(n);
            } else {  // 크기가 다를 때, minHeap쪽에 넣어줌
                minHeap.add(n);
            }

            //서로 비어있지 않고, 정렬이 안되어 있을 때
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }

            bw.write(maxHeap.peek() + "\n");

        }

        bw.flush();

    }
}
