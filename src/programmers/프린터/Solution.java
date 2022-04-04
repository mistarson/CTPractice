package programmers.프린터;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Print(i, priorities[i]));
        }

        int nowLocation = 0;
        while (!queue.isEmpty()) {
            Print current = queue.poll();
            boolean check = false;

            for (Print next : queue) {
                if (current.priority < next.priority) {
                    check = true;
                }
            }

            if (check) {
                queue.add(current);
            } else {
                nowLocation++;
                if (current.location == location) {
                    answer = nowLocation;
                }
            }
        }

        return answer;
    }

    static class Print {
        int location;
        int priority;

        public Print(int order, int priority) {
            this.location = order;
            this.priority = priority;
        }
    }

}
