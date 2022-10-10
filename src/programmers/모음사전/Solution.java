package programmers.모음사전;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int idx = 1;

    public static void main(String[] args) {
        int aaaae = new Solution().solution("EIO");
        System.out.println(aaaae);
    }

    public int solution(String word) {

        char[] words = {'A', 'E', 'I', 'O', 'U'};
        Map<String, Integer> map = new HashMap<>();
        setWords(0, "", words, map);
        System.out.println(map);

        return map.get(word);
    }

    static void setWords(int length, String temp, char[] words, Map<String, Integer> map) {

        if (length == 5) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            map.put(temp + words[i], idx++);
            setWords(length + 1, temp + words[i], words, map);
        }
    }
}
