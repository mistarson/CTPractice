package programmers.튜플;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] solution = new Solution().solution(s);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String s) {
        Map<Integer, Integer> map = new TreeMap<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                temp += s.charAt(i);
            } else {
                if (!temp.isBlank()) {
                    map.put(Integer.parseInt(temp), map.getOrDefault(Integer.parseInt(temp), 0) + 1);
                    temp = "";
                }
            }
        }

        int size = map.size();
        int[] answer = new int[size];
        for (Integer key : map.keySet()) {
            answer[size - map.get(key)] = key;
        }

        return answer;
    }

}