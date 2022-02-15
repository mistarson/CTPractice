package programmers.큰수만들기;

public class Solution {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));

    }
    static String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int count = number.length() - k;

        int startIndex = 0;
        for (int i = 0; i < count; i++) {
            int allowance = number.length() - (count - sb.length());
            int maxNumber = Integer.MIN_VALUE;
            for (int j = startIndex; j <= allowance; j++) {
                int compareNumber = number.charAt(j) - '0';

                if (maxNumber < compareNumber) {
                    maxNumber = compareNumber;
                    startIndex = j + 1;
                }
            }
            sb.append(maxNumber);
        }
        return answer = sb.toString();
    }
}
