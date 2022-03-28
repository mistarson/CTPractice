package programmers.level2.메뉴리뉴얼;

import java.util.*;

public class Solution {
    static List<String> results = new ArrayList<>();
    public static void main(String[] args) {

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] solution = solution(orders, course);

        System.out.println(Arrays.toString(solution));

    }

    static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            orders[i] = s;
        }

        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> courseCnt = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[] visited = new boolean[orders[j].length()];
                findCourse(courseCnt, visited, 0, 0 ,  course[i], orders[j], sb);
            }
            if (courseCnt.isEmpty()) {
                continue;
            }
            List<Course> courseList = new ArrayList<>();
            for (String key : courseCnt.keySet()) {
                courseList.add(new Course(key, courseCnt.get(key)));
            }

            Collections.sort(courseList);


            int max = courseList.get(0).cnt;
            if (max >= 2) {
                results.add(courseList.get(0).course);
                for (int j = 1; j < courseList.size(); j++) {
                    if (courseList.get(j).cnt == max) {
                        results.add(courseList.get(j).course);
                    }else break;
                }
            }

        }

        answer = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    static void findCourse(Map<String, Integer> courseCnt, boolean[] visited, int length, int start, int targetLength, String needCourse, StringBuilder sb) {
        if (length == targetLength) {
            courseCnt.put(sb.toString(), courseCnt.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < needCourse.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(needCourse.charAt(i));
                findCourse(courseCnt, visited, length + 1, i, targetLength, needCourse, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }

    }

    static class Course implements Comparable<Course> {
        String course;
        int cnt;

        public Course(String course, int cnt) {
            this.course = course;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Course o) {
            return Integer.compare(o.cnt, cnt);
        }
    }
}
