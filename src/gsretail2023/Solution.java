package gsretail2023;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int CARD_ROW = 3;
    static final int CARD_COL = 8;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cards = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] words = {"GPQM", "GPMZ", "EFU", "MMNA"};
        List<String> solution1 = solution.solution(cards, words);

        System.out.println(solution1);

    }

    public List<String> solution(String[] cards, String[] words) {
        List<String> ableWordList = new ArrayList<>();


        // 어떤 단어도 만들지 못하였을 때
        if (ableWordList.size() == 0) {
            ableWordList.add("-1");
        }

        return ableWordList;
    }

    static class Card {
        int line;
        int position;
    }
}

