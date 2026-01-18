package programmers.의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(new Solution().solution(clothes));
    }
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        for (String clothe : map.keySet()) {
            answer *= (map.get(clothe) + 1);
        }

        return answer - 1;
    }
}
