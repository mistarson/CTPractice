package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class backjoon_1342 {
    static Set<String> answerList = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] stringSplit = br.readLine().toCharArray();
        boolean[] isVisited = new boolean[stringSplit.length];

        getLuckyStr(stringSplit.length, "", ' ', stringSplit, isVisited);

        System.out.println(answerList.size());

    }

    static void getLuckyStr(int maxLength, String currentStr, char exchar, char[] stringSplit, boolean[] isVisited) {
        if (currentStr.length() >= maxLength) {
            answerList.add(currentStr);
            return;
        }

        for (int i = 0; i < stringSplit.length; i++) {
            if (!isVisited[i]) {
                if (exchar != stringSplit[i]) {
                    isVisited[i] = true;
                    getLuckyStr(maxLength, currentStr + stringSplit[i], stringSplit[i], stringSplit, isVisited);
                    isVisited[i] = false;
                }
            }

        }
    }
}
