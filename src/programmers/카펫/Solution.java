package programmers.카펫;

import java.util.*;

public class Solution {

    static int[] answer = new int[2];
    static List<Integer> width = new ArrayList<>();
    static List<Integer> height = new ArrayList<>();

    public static void main(String[] args) {

        solution(24, 24);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int i = 3; i <= (int) Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                height.add(i);
                width.add(sum / i);
            }
        }

        for (int i = 0; i < height.size(); i++) {
            int tempYellow = (height.get(i) - 2) * (width.get(i) - 2);
            if (yellow == tempYellow) {
                answer[0] = width.get(i);
                answer[1] = height.get(i);
            }
        }

        return answer;
    }
}