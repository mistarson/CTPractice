package programmers.캐시;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"a","b","c","b","d"};
        int solution = new Solution().solution(cacheSize, cities);
        System.out.println(solution);
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> cashSet = new HashSet<>();
        for (int i = 0; i < cities.length; i++) {
            String currentCity = cities[i];
            if (cashSet.contains(currentCity)) {
                queue.remove(currentCity);
                answer += 1;
            } else {
                if (queue.size() >= cacheSize) {
                    String poll = queue.poll();
                    cashSet.remove(poll);
                }
                answer += 5;
            }
            if (cacheSize > 0) {
                cashSet.add(currentCity);
                queue.add(currentCity);
            }
            System.out.println(queue);

        }
        return answer;
    }
}
