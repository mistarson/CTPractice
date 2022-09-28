package programmers.다리를지나가는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int solution = new Solution1().solution(bridge_length, weight, truck_weights);
        System.out.println(solution);
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        boolean[] isStarted = new boolean[truck_weights.length];
        Queue<Truck> queue = new LinkedList<>();
        int complTruck = 0;

        int currentWeight = 0;
        int currentTime = 0;
        loop:
        while (true) {
            currentTime++;
            while (!queue.isEmpty()) {
                Truck truck = queue.peek();
                if (currentTime - truck.inTime >= bridge_length) {
                    queue.poll();
                    currentWeight -= truck.weight;
                    if (++complTruck == truck_weights.length) {
                        break loop;
                    }
                }else break;
            }
            for (int i = 0; i < truck_weights.length; i++) {
                if (!isStarted[i]) {
                    if (currentWeight + truck_weights[i] <= weight) {
                        isStarted[i] = true;
                        currentWeight += truck_weights[i];
                        queue.add(new Truck(truck_weights[i], currentTime));
                    }
                    break;
                }
            }
        }
        return currentTime;
    }


    static class Truck {
        int weight;
        int inTime;

        public Truck(int weight, int inTime) {
            this.weight = weight;
            this.inTime = inTime;
        }
    }
}
