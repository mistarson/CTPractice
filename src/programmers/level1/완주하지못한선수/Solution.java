package programmers.level1.완주하지못한선수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<Integer, String> player = new HashMap<>();
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            player.put(i, completion[i]);
        }

        for (int i = 0; i < participant.length; i++) {
            if (i == participant.length - 1) {
                return answer = participant[i];
            }
            if (!player.get(i).equals(participant[i])) {
                return answer = participant[i];
            }

        }

        return answer;
    }
}
