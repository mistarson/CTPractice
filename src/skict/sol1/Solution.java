package skict.sol1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int[] monetaryUnits = {1, 5, 10, 50, 100, 500};

    public static void main(String[] args) {

        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};
        System.out.println(solution(money, costs));
    }

    static int solution(int money, int[] costs) {
        int answer = 0;
        List<Coin> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Coin(monetaryUnits[i], costs[i], (double) monetaryUnits[i] / (double) costs[i]));
        }
        Collections.sort(list);

        int stockMoney = money;
        int totalProductionCost = 0;

        for (int i = 0; i < 6; i++) {
            if (stockMoney == 0) break;
            if(stockMoney < list.get(i).monetaryUnit) continue;
            totalProductionCost += (stockMoney / list.get(i).monetaryUnit) * list.get(i).productionCost;
            stockMoney = stockMoney % list.get(i).monetaryUnit;
        }


        return totalProductionCost;
    }

    static class Coin implements Comparable<Coin> {
        int monetaryUnit;
        int productionCost;
        double productionEfficiency;

        public Coin(int monetaryUnit, int productionCost, double productionEfficiency) {
            this.monetaryUnit = monetaryUnit;
            this.productionCost = productionCost;
            this.productionEfficiency = productionEfficiency;
        }

        @Override
        public int compareTo(Coin o) {
            int comp1 = Double.compare(o.productionEfficiency, productionEfficiency);
            if (comp1 == 0) {
                return Integer.compare(o.monetaryUnit, monetaryUnit);
            }
            return comp1;
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "monetaryUnit=" + monetaryUnit +
                    ", productionCost=" + productionCost +
                    ", productionEfficiency=" + productionEfficiency +
                    '}' + "\n";
        }
    }
}
