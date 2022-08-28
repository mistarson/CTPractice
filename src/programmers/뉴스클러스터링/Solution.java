package programmers.뉴스클러스터링;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str1 = "A+C";
        String str2 = "DEF";

        int solution = new Solution().solution(str1, str2);
        System.out.println(solution);

    }

    public int solution(String str1, String str2) {
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        initialMap(str1, str1Map);
        initialMap(str2, str2Map);

        System.out.println("str1Map = " + str1Map);
        System.out.println("str2Map = " + str2Map);

        int intersection = intersection(str1Map, str2Map);
        int union = union(str1Map, str2Map, intersection);

        if (intersection == 0 && union == 0) {
            return 65536;
        }

        System.out.println("intersection = " + intersection);
        System.out.println("union = " + union);

        double divide = (double) intersection / (double) union;
        int answer = (int) (divide * 65536);

        return answer;
    }

    static void initialMap(String str, Map<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            String temp = "";
            if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))) {
                continue;
            }
            if (!((str.charAt(i + 1) >= 'A' && str.charAt(i + 1) <= 'Z') || (str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z'))) {
                continue;
            }
            temp += str.charAt(i);
            temp += str.charAt(i + 1);

            String lowerTemp = temp.toLowerCase();
            map.put(lowerTemp, map.getOrDefault(lowerTemp, 0) + 1);
        }
    }

    static int intersection(Map<String, Integer> str1Map, Map<String, Integer> str2Map) {
        int intersection = 0;
        for (String str : str1Map.keySet()) {
            if (str2Map.containsKey(str)) {
                intersection += Math.min(str1Map.get(str), str2Map.get(str));
            }
        }
        return intersection;
    }

    static int union(Map<String, Integer> str1Map, Map<String, Integer> str2Map, int intersection) {
        int str1MapValue = 0;
        int str2MapValue = 0;
        for (Integer value : str1Map.values()) {
            str1MapValue += value;
        }
        for (Integer value : str2Map.values()) {
            str2MapValue += value;
        }

        return (str1MapValue + str2MapValue) - intersection;

    }
}
