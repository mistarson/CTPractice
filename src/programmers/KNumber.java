package programmers;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;

public class KNumber {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 3, 3}
        };
        Solution solution = new Solution();
        int[] result = solution.solution(array, commands);
        System.out.println(Arrays.toString(result));
    }


    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int[] temp = copyOfRange(array, commands[i][0]-1, commands[i][1]);
                sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }
            return answer;
        }
    }
}
