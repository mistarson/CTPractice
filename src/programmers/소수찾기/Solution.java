package programmers.소수찾기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        solution("17");
    }

    static int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        StringBuilder sb = new StringBuilder();

        char[] numbersArr = new char[length];

        for (int i = 0; i < length; i++) {
            numbersArr[i] = numbers.charAt(i);
        }

        for (int i = 0; i < length; i++) {
            sb.append(numbers.charAt(i));
            if (isPrime(sb.toString())) {
                answer++;
            }
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                sb.append(numbers.charAt(j));
                
            }
            sb.setLength(0);
        }

        return answer;
    }

    static boolean isPrime(String numbers) {
        int number = Integer.parseInt(numbers);
        if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0) {
            return true;
        }
        return false;
    }
}
