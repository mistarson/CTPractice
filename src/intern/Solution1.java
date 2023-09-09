package intern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[][] lotteries = {{10, 1, 500}, {1000, 1000, 100}};
        int solution = new Solution1().solution(lotteries);
        System.out.println(solution);
    }
    public int solution(int[][] lotteries) {

        List<Lottery> lotteryList = new ArrayList<>();
        for (int i = 0; i < lotteries.length; i++) {
            double winPercent = (double) lotteries[i][0] / (lotteries[i][1] + 1);
            int winnings = lotteries[i][2];
            lotteryList.add(new Lottery(i + 1, winPercent, winnings));
        }

        Collections.sort(lotteryList);

        return lotteryList.get(0).index;
    }

    static class Lottery implements Comparable<Lottery> {

        int index;
        double winPercent;
        int winnings;

        public Lottery(int index, double winPercent, int winnings) {
            this.index = index;
            this.winPercent = winPercent;
            this.winnings = winnings;
        }

        @Override
        public int compareTo(Lottery o) {
            int comp1 = Double.compare(o.winPercent, winPercent);
            if (comp1 == 0) {
                return Integer.compare(o.winnings, winnings);
            }
            return comp1;
        }
    }
}
