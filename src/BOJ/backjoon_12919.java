package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_12919 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        isPossibleStoT(T, S);

        System.out.println(answer);
    }

    static void isPossibleStoT(String currentStr, String S) {
        if (currentStr.equals(S)) {
            answer = 1;
            return;
        }

        if (currentStr.length() == S.length()) {
            return;
        }

        if (currentStr.charAt(0) == 'B') {
            String reverseStr = reverseStr(currentStr);
            isPossibleStoT(reverseStr.substring(0, reverseStr.length() - 1), S);
        }

        if (currentStr.charAt(currentStr.length() - 1) == 'A') {
            isPossibleStoT(currentStr.substring(0, currentStr.length() - 1), S);
        }

    }

    static String reverseStr(String str) {
        StringBuilder reverseStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr.append(str.charAt(i));
        }

        return reverseStr.toString();
    }
}
