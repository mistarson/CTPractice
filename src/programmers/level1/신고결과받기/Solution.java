package programmers.level1.신고결과받기;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
        System.out.println(Arrays.toString(solution));
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String, List<String>> reportMap = new HashMap<>(); // 해당 ID를 신고한 다른 ID를 모아놓은 맵
        Map<String, Integer> result = new HashMap<>(); // 최종 메일 수를 담기 위한 맵


        for (String id : id_list) {
            result.put(id, 0);
            reportMap.put(id, new ArrayList<>());
        }

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String reporter = st.nextToken(); // 신고한 사람
            String reported = st.nextToken(); // 신고 당한 사람
            reportMap.get(reported).add(reporter); //신고당한 사람 LIST에 신고한 사람 추가
        }

        for (String person : reportMap.keySet()) {
            if (reportMap.get(person).size() == k) { //신고 당한 횟수가 K번 이상이라면?
                for (String reportPerson : reportMap.get(person)) { // 신고한 사람의 메일 수 추가
                    result.put(reportPerson, result.getOrDefault(reportPerson, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}

