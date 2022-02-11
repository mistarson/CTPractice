package programmers.가장큰수;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] number = {6, 10, 2};

        String solution = solution(number);

        System.out.println(solution);

    }

    static String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        Collections.sort(list, (o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));
        StringBuilder sb = new StringBuilder();

        if (list.get(0).equals("0")) {
            return "0";
        }
        for (String number : list) {
            sb.append(number);
        }

        answer = sb.toString();

        return answer;
    }


}
