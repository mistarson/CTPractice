package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (isPalindrome(str)) {
            System.out.println(1);
        }else System.out.println(0);
    }

    static boolean isPalindrome(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            String front = str.substring(0, length / 2);
            String back = str.substring(length / 2);

            return front.equals(reverseStr(back));
        } else {
            String front = str.substring(0, length / 2);
            String back = str.substring((length / 2) + 1);

            return front.equals(reverseStr(back));
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
