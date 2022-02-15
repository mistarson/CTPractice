package programmers.구명보트;

import java.util.*;

public class Solution {
    //TODO 효율성, 다른 테케 다시 봐야 함
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int solution = solution(people, limit);
        System.out.println("solution = " + solution);
    }
    static int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> peopleList = new ArrayList<>();

        for (int n : people) {
            peopleList.add(n);
        }

        Collections.sort(peopleList, Collections.reverseOrder());

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for (int n : peopleList) {
            map.put(i++, n);
        }

        while (!map.isEmpty()) {
            int sum = 0;
            List<Integer> removeList = new ArrayList<>();

            for (int n : map.keySet()) {
                if (sum + map.get(n) <= limit) {
                    sum += map.get(n);
                    removeList.add(n);
                }
            }

            for (int n : removeList) {
                map.remove(n);
            }

            answer++;
        }

        return answer;
    }
}
