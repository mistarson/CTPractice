package programmers.숫자게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        int solution = new Solution().solution(A, B);
        System.out.println(solution);
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> listB = new ArrayList<>();
        for (int num : B) {
            listB.add(num);
        }

        Collections.sort(listB);

        for (int i = 0; i < A.length; i++) {

            int low = 0;
            int high = listB.size() - 1;
            int temp = 0;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (A[i] < listB.get(mid)) {
                    high = mid - 1;
                    temp = mid;
                } else {
                    low = mid + 1;
                }
            }

            if (listB.get(temp) > A[i]) {
                answer++;
            }
            listB.remove(temp);
        }
        return answer;
    }
}
