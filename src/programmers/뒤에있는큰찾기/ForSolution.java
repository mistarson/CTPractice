package programmers.뒤에있는큰찾기;

import java.util.*;

public class ForSolution {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int length = numbers.length;

        Arrays.fill(answer, -1);

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                } else {
                    if (answer[j] == -1) {
                        answer[i] = -1;
                        break;
                    } else if (numbers[i] < answer[j]) {
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }

        return answer;
    }

}
