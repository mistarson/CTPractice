package programmers.전화번호목록;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};

        solution(phone_book);
    }

    static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> pbMap = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            pbMap.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String substring = phone_book[i].substring(0, j); // substring(end 전까지 그니까 end-1까지 나옴)
                if (pbMap.containsKey(substring)) {
                    return answer = false;
                }
            }
        }

        return answer;
    }
}
