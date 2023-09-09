package last;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {

        String[] subway1 = {"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
        int start1 = 1;
        int end1 = 9;
        int result = 1;

        String[] subway2 = {"1 2 3 4 5 6 7 8 9 10", "2 8"};
        int start2 = 1;
        int end2 = 10;
        int result2 = 0;

        String[] subway3 = {"0 1 2 3 4", "1 12 13 14"};
        int start3 = 2;
        int end3 = 12;
        int result3 = 1;

    }
//    public int solution(String[] subway, int start, int end) {
//        int answer = 0;
//
//        List<List<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < subway.length; i++) {
//            graph.add(new ArrayList<>());
//            StringTokenizer st = new StringTokenizer(subway[i]);
//            int cnt = st.countTokens();
//            for (int j = 0; j < cnt; j++) {
//                graph.get(i).add(Integer.parseInt(st.nextToken()));
//            }
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start + 1);
//        while (!queue.isEmpty()) {
//            int station = queue.poll();
//
//            for (java.lang.Object o : graph.ge) {
//
//            }
//        }
//        return answer;
//    }
}
