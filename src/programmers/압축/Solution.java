package programmers.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        int[] solution = new Solution().solution(msg);
    }

    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int value = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), value++);
        }

        int idx = 0;
        String temp = "";
        for (; idx < msg.length(); idx++) {
            temp += msg.charAt(idx);
            if (map.containsKey(temp)) {
                if (idx == msg.length() - 1) {
                    list.add(map.get(temp));
                }
                continue;
            }
            idx--;
            String existString = temp.substring(0, temp.length() - 1);
            list.add(map.get(existString));
            map.put(temp, value++);
            temp = "";
        }


        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
