package programmers.다리를지나가는트럭;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        int solution = solution(bridge_length, weight, truck_weights);

        System.out.println(solution);

    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> waitingTrucks = new LinkedList<>();
        List<Truck> crossingTrucks = new ArrayList<>();

        for (int truck_weight : truck_weights) {
            waitingTrucks.add(new Truck(truck_weight));
        }

        int sum = 0;
        while (!crossingTrucks.isEmpty() || !waitingTrucks.isEmpty()) {

            answer++;

            int j = 0;
            int size = crossingTrucks.size();
            for (int i = 0; i < size; i++) {
                crossingTrucks.get(j).time++;
                if (crossingTrucks.get(j).time == bridge_length) {
                    sum -= crossingTrucks.get(j).truckWeight;
                    crossingTrucks.remove(j);
                } else {
                    j++;
                }
            }

            if (!waitingTrucks.isEmpty()) {
                if (bridge_length > crossingTrucks.size()) {
                    if (waitingTrucks.peek().truckWeight + sum <= weight) {
                        Truck truck = waitingTrucks.poll();
                        sum += truck.truckWeight;
                        crossingTrucks.add(truck);
                    }
                }
            }

        }
        return answer;
    }

    static class Truck {
        int time;
        int truckWeight;

        public Truck(int truckWeight) {
            this.time = 0;
            this.truckWeight = truckWeight;
        }
    }

}
