package sds.p1202;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jewelCnt = Integer.parseInt(st.nextToken());
        int bagCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>();
        PriorityQueue<Long> bags = new PriorityQueue<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < jewelCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int jewelWeight = Integer.parseInt(st.nextToken());
            int jewelPrice = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(jewelWeight, jewelPrice));
        }

        for (int i = 0; i < bagCnt; i++) {
            long bagWeight = Long.parseLong(br.readLine());
            bags.add(bagWeight);
        }

        long result = 0;
        for (int i = 0; i < bagCnt; i++) {
            while (true) {
                if (jewels.size() == 0) {
                    break;
                }

                if (bags.peek() >= jewels.peek().weight) {
                    pq.add(jewels.poll().price);
                } else{
                    bags.poll();
                    break;
                }

            }

            if (pq.size() > 0) {
                result += pq.poll();
            }

        }

        System.out.println(result);
    }

    static class Jewel implements Comparable<Jewel> {
        long weight;
        long price;

        public Jewel(long weight, long price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Jewel{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}' + "\n";
        }

        @Override
        public int compareTo(Jewel o) {
            return Long.compare(weight, o.weight);
        }
    }
}
