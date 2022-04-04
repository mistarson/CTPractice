package programmers.위장;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }
    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String str : map.keySet()) {
            answer *= map.get(str) + 1;
        }

        return answer - 1;
    }
}
