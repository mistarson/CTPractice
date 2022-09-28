package programmers.메뉴리뉴얼;

import java.util.*;

public class Solution {
    static int max = 0;
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] solution = new Solution().solution(orders, course);
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }
        List<String> courseList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            max = 0;
            Map<String, Integer> courseMap = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                getCourse(0, 0, "", orders[j], courseMap, course[i]);
            }
            if (max < 2) {
                continue;
            }

            for (String key : courseMap.keySet()) {
                if (courseMap.get(key) == max) {
                    courseList.add(key);
                }
            }
        }


        String[] answer = new String[courseList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = courseList.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public void getCourse(int length, int start, String temp, String course, Map<String, Integer> courseMap, int courseCnt) {
        if (length == courseCnt) {
            courseMap.put(temp, courseMap.getOrDefault(temp, 0) + 1);
            max = Math.max(max, courseMap.get(temp));
            return;
        }

        for (int i = start; i < course.length(); i++) {
            getCourse(length + 1, i + 1, temp + course.charAt(i), course, courseMap, courseCnt);
        }
    }
}
