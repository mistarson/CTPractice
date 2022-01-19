package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class backjoon_11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        MaxHeap maxHeap = new MaxHeap();


        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                bw.write(maxHeap.delete()+"\n");
            } else {
                maxHeap.insert(n);
            }
        }
        bw.flush();
    }

    static class MaxHeap {

        List<Integer> list;

        public MaxHeap() {
            list = new ArrayList<>();
            list.add(0);
        }

        public void insert(int val) {

            list.add(val);

            int current = list.size() - 1;
            int parent = current / 2;
            while (true) {
                if (parent == 0 || list.get(parent) >= list.get(current)) {
                    break;
                }

                int temp = list.get(parent);
                list.set(parent, list.get(current));
                list.set(current, temp);

                current = parent;
                parent = current / 2;
            }
        }

        public int delete() {

            if (list.size() == 1) {
                return 0;
            }

            int top = list.get(1);
            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentPos = 1;
            while (true) {
                int leftPos = currentPos * 2;
                int rightPos = currentPos * 2 + 1;

                if (leftPos >= list.size()) {
                    break;
                }

                int maxValue = list.get(leftPos);
                int maxPos = leftPos;

                if (rightPos < list.size() && list.get(rightPos) > maxValue) {
                    maxValue = list.get(rightPos);
                    maxPos = rightPos;
                }

                if (list.get(currentPos) < maxValue) {
                    int temp = list.get(currentPos);
                    list.set(currentPos, maxValue);
                    list.set(maxPos, temp);
                    currentPos = maxPos;
                } else {
                    break;
                }
            }
            return top;
        }


    }

}
