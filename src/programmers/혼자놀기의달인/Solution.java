package programmers.혼자놀기의달인;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        int[] score = new int[101];
        Arrays.fill(score, -1);
        for (int i = 0; i < cards.length; i++) {
            if (score[cards[i]] == -1) {
                List<List<Integer>> cardListGroupByBox = new ArrayList<>();
                answer = Math.max(answer, getScore(0, cards[i], score, cards, cardListGroupByBox));
            }
        }
        return answer;
    }

    static int getScore(int idx, int card, int[] score, int[] cards, List<List<Integer>> cardListGroupByBox) {

        cardListGroupByBox.add(new ArrayList<>());

        while (card <= cards.length) {
            cardListGroupByBox.get(idx).add(card);
            card = cards[card];
        }

        if (cardListGroupByBox.get(idx).size() == cards.length) {
            return 0;
        }

        for (int cardNum : cardListGroupByBox.get(idx)) {
            score[cardNum] = cardListGroupByBox.get(idx).size();
        }

        for (int i = 0; i < cards.length; i++) {
            if (score[cards[i]] != -1) {
                getScore(idx + 1, cards[i], score, cards, cardListGroupByBox);
            }
        }

    }
}
