package programmers.level1.실패율;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int N = 4;
        int[] stages = {4,4,4,4,4};

        solution(N, stages);

    }

    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Stage> priorityQueue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        int[] clearPeople = new int[N + 1];

        for (int n : stages) {
            list.add(n);
        }

        Collections.sort(list);

        for (int i = 1; i <= N; i++) {
            clearPeople[i] = Collections.frequency(list, i);
        }

        int people = stages.length;
        for (int i = 1; i <= N; i++) {
            if (clearPeople[i] == 0) {
                priorityQueue.add(new Stage(i, 0));
                continue;
            }
            double failureRate = (double)clearPeople[i] / (double) people;
            priorityQueue.add(new Stage(i, failureRate));
            people -= clearPeople[i];
        }
        for (int i = 0; i < N; i++) {
            answer[i] = priorityQueue.poll().stageNumber;
        }

        return answer;
    }

    static class Stage implements Comparable<Stage>{
        int stageNumber;
        double failureRate;

        public Stage(int stageNumber, double failureRate) {
            this.stageNumber = stageNumber;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            int comp1 = Double.compare(o.failureRate, failureRate);
            if (comp1 == 0) {
                return Integer.compare(stageNumber, o.stageNumber);
            }
            return comp1;
        }
    }
}
