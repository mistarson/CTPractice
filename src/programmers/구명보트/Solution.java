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
        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if (people[max] + people[min] > limit) {
                answer++;
            } else {
                answer++;
                min++;
            }
        }
        return answer;
    }
}
