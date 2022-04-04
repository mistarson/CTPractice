package programmers.기능개발;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] solution = solution(progresses, speeds);

        System.out.println(Arrays.toString(solution));

    }
    static int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        Map<Integer, Integer> days = new HashMap<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            while (progress + speeds[i] * day < 100) {
                day++;
            }
            days.put(day, days.getOrDefault(day, 0) + 1);
        }
        int[] answer = new int[days.size()];
        List<Integer> sortList = new ArrayList<>(days.keySet());
        Collections.sort(sortList);

        for (int i = 0; i < sortList.size(); i++) {
            answer[i] = days.get(sortList.get(i));
        }
        return answer;
    }
}
