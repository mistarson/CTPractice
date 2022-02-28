package programmers.level1.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        int[] numbers = {2, 1, 3, 4, 1};

        solution(numbers);

    }
    static int[] solution(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];

        sumNumbers(0, 0, 0, numbers,visited);
        List<Integer> disList = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(disList);
        int[] answer = new int[disList.size()];
        for (int i = 0; i < disList.size(); i++) {
            answer[i] = disList.get(i);
        }


        return answer;
    }

    static void sumNumbers(int length, int sum, int start, int[] numbers, boolean[] visited) {
        if (length == 2) {
            list.add(sum);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += numbers[i];
                sumNumbers(length + 1, sum, i, numbers, visited);
                sum -= numbers[i];
                visited[i] = false;
            }
        }
    }
}
