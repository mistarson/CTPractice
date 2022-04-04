package programmers.level2.단체사진찍기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int answer;
    static boolean[] visited = new boolean[8];
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        int solution = solution(n, data);
        System.out.println(solution);
    }

    static int solution(int n, String[] data) {
        answer = 0;
        Map<String, Integer> picturePosition = new HashMap<>();
        dfs(0, picturePosition, data);
        return answer;
    }

    static void dfs(int length, Map<String, Integer> picturePosition, String[] data) {

        if (length == 8) {
            if (checkNeeds(picturePosition, data)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picturePosition.put(friends[i], length + 1);
                dfs(length + 1, picturePosition, data);
                picturePosition.remove(friends[i]);
                visited[i] = false;
            }
        }
    }

    static boolean checkNeeds(Map<String, Integer> map, String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] split = data[i].split("");
            String friend1 = split[0];
            String friend2 = split[2];
            String condition = split[3];
            int conditionValue = Integer.parseInt(split[4]);
            int distance = Math.abs(map.get(friend1) - map.get(friend2)) - 1; // 두 프렌즈 사이에 있는 프렌즈 수

            if (condition.equals("=") && conditionValue == distance) {
                continue;
            } else if (condition.equals(">") && conditionValue < distance) {
                continue;
            } else if (condition.equals("<") && conditionValue > distance) {
                continue;
            } else return false;
        }
        return true;
    }
}
