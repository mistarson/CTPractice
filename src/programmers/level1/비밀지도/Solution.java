package programmers.level1.비밀지도;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] solution = solution(n, arr1, arr2);

        System.out.println(Arrays.toString(solution));

    }
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String s1 = Integer.toString(arr1[i], 2);
            String s2 = Integer.toString(arr2[i], 2);

            if (s1.length() < n) {
                while (s1.length() < n) {
                    s1 = 0 + s1;
                }
            }

            if (s2.length() < n) {
                while (s2.length() < n) {
                    s2 = 0 + s2;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == '1' || s2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
