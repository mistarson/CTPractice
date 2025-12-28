package programmers.완주하지못한선수;

import java.util.*;

public class Solution {
    /*
     * 제한 사항
     * 1. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * 2. completion의 길이는 participant의 길이보다 1 작습니다.
     * 3. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * 4. 참가자 중에는 동명이인이 있을 수 있습니다.
     * */
    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden", "leo"};
        String[] completion = {"eden", "kiki", "leo"};

        Solution solution = new Solution();
        String answer = solution.solution(participant, completion);

        System.out.println(answer);
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> answerMap = new HashMap<>();
        for (String name : participant) {
            answerMap.merge(name, 1, Integer::sum);
        }
        for (String name : completion) {
            Integer value = answerMap.get(name);
            if (value == 1) answerMap.remove(name);
            else answerMap.replace(name, value - 1);
        }
        return answerMap.keySet().iterator().next();
    }
}
