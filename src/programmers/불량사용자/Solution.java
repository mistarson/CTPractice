package programmers.불량사용자;

import java.util.*;

public class Solution {
    static Set<String> possibleCaseSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        boolean[] isVisited = new boolean[user_id.length];
        String[] caseArr = new String[banned_id.length];
        getPossibleCase(0, caseArr, user_id, banned_id, isVisited);

        System.out.println(possibleCaseSet);

        return possibleCaseSet.size();
    }

    public void getPossibleCase(int depth, String[] caseArr, String[] user_id, String[] banned_id, boolean[] isVisited) {
        if (depth == banned_id.length) {
            String[] tempArr = new String[caseArr.length];
            for (int i = 0; i < caseArr.length; i++) {
                tempArr[i] = caseArr[i];
            }
            Arrays.sort(tempArr);
            String temp = "";
            for (int i = 0; i < tempArr.length; i++) {
                temp += tempArr[i];
            }
            possibleCaseSet.add(temp);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!isVisited[i]) {
                if (isPossible(user_id[i], banned_id[depth])) {
                    isVisited[i] = true;
                    caseArr[depth] = user_id[i];
                    getPossibleCase(depth + 1, caseArr, user_id, banned_id, isVisited);
                    caseArr[depth] = "";
                    isVisited[i] = false;
                }
            }
        }
    }

    public boolean isPossible(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }
            if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}