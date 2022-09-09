package programmers.수식최대화;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static char[] opt = {'*', '+', '-'};
    static long maxReward = Integer.MIN_VALUE;

    public static void main(String[] args) {

        long solution = new Solution().solution("100-200*300-500+20");
        System.out.println(solution);

    }

    public long solution(String expression) {
        boolean[] isVisited = new boolean[3];
        getMaxReward(0, expression, isVisited);
        return maxReward;
    }

    static void getMaxReward(int depth, String temp, boolean[] isVisited) {
        if (depth == 3) {
            long reward = Math.abs(Long.parseLong(temp));
            maxReward = Math.max(maxReward, reward);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String calculateStr = calculate(temp, opt[i]);
                getMaxReward(depth + 1, calculateStr, isVisited);
                isVisited[i] = false;
            }
        }

    }

    static String calculate(String temp, char opt) {

        List<Long> numberList = new ArrayList<>();
        List<Character> optList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            if ((sb.length() != 0 &&temp.charAt(i) == '-') || temp.charAt(i) == '*' || temp.charAt(i) == '+') {
                optList.add(temp.charAt(i));
                Long number = Long.valueOf(sb.toString());
                numberList.add(number);
                sb.setLength(0);
            } else {
                sb.append(temp.charAt(i));
            }
        }
        Long number = Long.valueOf(sb.toString());
        numberList.add(number);

        for (int i = 0; i < optList.size(); i++) {
            if (optList.get(i) == opt) {
                long value = 0;
                switch (opt) {
                    case '*':
                        value = numberList.get(i) * numberList.get(i + 1);
                        numberList.set(i, value);
                        break;
                    case '+':
                        value = numberList.get(i) + numberList.get(i + 1);
                        numberList.set(i, value);
                        break;
                    case '-':
                        value = numberList.get(i) - numberList.get(i + 1);
                        numberList.set(i, value);
                        break;
                }
                numberList.set(i, value);
                numberList.remove(i + 1);
                optList.remove(i);
                i--;
            }
        }

        StringBuilder calculSb = new StringBuilder();
        calculSb.append(numberList.get(0));
        for (int i = 0; i < optList.size(); i++) {
            calculSb.append(optList.get(i));
            calculSb.append(numberList.get(i + 1));
        }


        return calculSb.toString();
    }
}
