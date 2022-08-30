package programmers.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] solution = new Solution().solution(gems);
        System.out.println(Arrays.toString(solution));

    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> totalKindCheckMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            totalKindCheckMap.put(gems[i], 1);
        }
        int totalKind = totalKindCheckMap.size();

        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        int kind = 0;
        while (end <= gems.length) {

            if (kind < totalKind) {
                if (end == gems.length) {
                    break;
                }
                if (!map.containsKey(gems[end])) {
                    kind++;
                }
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            } else {

                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }

                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                    kind--;
                }
                start++;
            }

        }

        answer[0] = minStart + 1;
        answer[1] = minEnd;
        return answer;
    }
}
