package gabia;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int[] p = {20, 10, 10, 20};
        int solution = new Solution3().solution(p);

        System.out.println(solution);

    }

    public int solution(int[] p) {
        int answer = 0;

        Map<Integer, Card> cardMap = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            if (!cardMap.containsKey(p[i])) {
                cardMap.put(p[i], new Card(p[i], 1));
            } else cardMap.get(p[i]).cnt++;
        }

        List<Card> cardList = new ArrayList<>();
        for (Integer key : cardMap.keySet()) {
            cardList.add(new Card(key, cardMap.get(key).cnt));
        }

        Collections.sort(cardList);

        while (!cardList.isEmpty()) {

            int cardCnt = 0;
            for (int i = 0; i < cardList.size(); i++) {
                Card card = cardList.get(i);

                if (cardCnt++ >= 1) {
                    answer++;
                }

                if (--card.cnt == 0) {
                    cardList.remove(card);
                    i--;
                }
            }

        }

        return answer;
    }

    static class Card implements Comparable<Card> {
        int num;
        int cnt;

        public Card(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(num, o.num);
        }
    }
}
