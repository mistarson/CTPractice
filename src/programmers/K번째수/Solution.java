package programmers.K번째수;

import java.util.Arrays;

public class Solution {

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] copyArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copyArray);
            answer[i] = copyArray[commands[i][2] - 1];
        }

        return answer;
    }
}
