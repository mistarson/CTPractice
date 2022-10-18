package programmers.혼자놀기의달인;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int solution(int[] cards) {

        List<Integer> scoreGroupByBox = new ArrayList<>();
        boolean[] isOpened = new boolean[cards.length + 1];
        int[] scores = new int[101];
        for (int i = 0; i < cards.length; i++) {
            if (!isOpened[cards[i]]) {
                int score = getScore(cards[i], scores, cards, isOpened);
                if (score != 0) {
                    scoreGroupByBox.add(score);
                } else {
                    return 0;
                }
            }
        }

        Collections.sort(scoreGroupByBox, Collections.reverseOrder());

        return scoreGroupByBox.get(0) * scoreGroupByBox.get(1);
    }

    static int getScore(int card, int[] scores, int[] cards, boolean[] isOpened) {

        List<Integer> cardList = new ArrayList<>();

        while (card <= cards.length && !isOpened[card]) {
            isOpened[card] = true;
            cardList.add(card);
            card = cards[card - 1];
        }

        if (cardList.size() == cards.length) {
            return 0;
        }

        for (int cardNum : cardList) {
            scores[cardNum] = cardList.size();
        }

        return cardList.size();

    }
}
