package programmers.택배상자;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        int solution = new Solution().solution(order);
        System.out.println(solution);
    }

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subBelt = new Stack<>();

        int orderIdx = 0;
        for (int i = 1; i <= order.length; i++) {
            if (order[orderIdx] == i) {
                answer++;
                orderIdx++;
            } else if (order[orderIdx] > i) {
                subBelt.add(i);
            }
            while (!subBelt.isEmpty()) {
                if (subBelt.peek() == order[orderIdx]) {
                    answer++;
                    subBelt.pop();
                    orderIdx++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
