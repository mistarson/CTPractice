package programmers.이중우선순위큐;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] solution = new Solution().solution(operations);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String[] operations) {

        List<Integer> list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            switch (command) {
                case "I":
                    int item = Integer.parseInt(st.nextToken());
                    list.add(item);
                    break;
                case "D":
                    if (list.size() == 0) {
                        continue;
                    }
                    int minMax = Integer.parseInt(st.nextToken());
                    if (minMax == -1) {
                        Collections.sort(list);
                        list.remove(0);
                    } else {
                        Collections.sort(list, Collections.reverseOrder());
                        list.remove(0);
                    }
                    break;
            }
        }

        int[] answer = new int[2];
        if (list.size() > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                min = Math.min(min, list.get(i));
                max = Math.max(max, list.get(i));
            }
            answer[0] = max;
            answer[1] = min;
        }

        return answer;
    }
}
