package programmers.롤케이크자르기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] topping = {1,1,1,1,1};
        int solution = new Solution().solution(topping);
        System.out.println(solution);
    }

    public int solution(int[] topping) {
        int answer = 0;
        
        // 초기 맵 초기화
        Map<Integer, Integer> cheolsuTopping = new HashMap<>();
        Map<Integer, Integer> brotherTopping = new HashMap<>();

        cheolsuTopping.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            brotherTopping.put(topping[i], brotherTopping.getOrDefault(topping[i], 0) + 1);
        }

        if (cheolsuTopping.size() == brotherTopping.size()) {
            answer++;
        }

        // 마지막 토핑전까지 잘라보면서 종류가 같은지 확인하기
        for (int i = 1; i < topping.length - 1; i++) {
            cheolsuTopping.put(topping[i], cheolsuTopping.getOrDefault(topping[i], 0) + 1);
            brotherTopping.put(topping[i], brotherTopping.get(topping[i]) - 1);
            if (brotherTopping.get(topping[i]) == 0) {
                brotherTopping.remove(topping[i]);
            }

            if (cheolsuTopping.size() == brotherTopping.size()) {
                answer++;
            }
        }

        return answer;
    }

}
