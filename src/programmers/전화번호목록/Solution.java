package programmers.전화번호목록;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "976742231195524421"};

        System.out.println(solution(phone_book));
    }

    static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
