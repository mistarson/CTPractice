package programmers.기능개발;

import java.util.*;

public class FailSolution {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1,1,1,1,1};

        int[] solution = solution(progresses, speeds);

        System.out.println(Arrays.toString(solution));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }

        while (!queue.isEmpty()) {

            int[] temp = new int[queue.size()];
            int count = 1;

            for (int i = 0; i < temp.length; i++) {
                temp[i] = queue.poll() + speeds[i];
            }

            if (temp[0] >= 100) {
                temp[0] = 0;

                for (int i = 1; i < temp.length; i++) {
                    if (temp[i] >= 100) {
                        temp[i] = 0;
                        count++;
                    } else {
                        break;
                    }
                }
                list.add(count);
            }

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 0) {
                    continue;
                } else {
                    queue.add(temp[i]);
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
