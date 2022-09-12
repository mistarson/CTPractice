package programmers.순위검색;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] solution = new Solution().solution(info, query);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, ArrayList<Integer>> recruitInfo = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] splitInfo = info[i].split(" ");
            setRecruitInfo(0, "", splitInfo, recruitInfo);
        }

        for (String key : recruitInfo.keySet()) {
            Collections.sort(recruitInfo.get(key));
        }

        int idx = 0;
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" and | ");
            int score = Integer.parseInt(splitQuery[4]);
            String joinQuery = splitQuery[0] + splitQuery[1] + splitQuery[2] + splitQuery[3];

            if (!recruitInfo.containsKey(joinQuery)) {
                answer[idx++] = 0;
            } else {
                ArrayList<Integer> list = recruitInfo.get(joinQuery);

                int minIdx = findMinIdx(score, list);
                answer[idx++] = list.size() - minIdx;
            }

        }
        return answer;
    }

    static void setRecruitInfo(int cnt, String temp, String[] splitInfo, Map<String, ArrayList<Integer>> recruitInfo) {
        if (cnt == 4) {
            if (!recruitInfo.containsKey(temp)) {
                recruitInfo.put(temp, new ArrayList<>());
            }
            int score = Integer.parseInt(splitInfo[4]);
            recruitInfo.get(temp).add(score);
            return;
        }

        setRecruitInfo(cnt + 1, temp + splitInfo[cnt], splitInfo, recruitInfo);
        setRecruitInfo(cnt + 1, temp + "-", splitInfo, recruitInfo);

    }

    static int findMinIdx(int score, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
