package programmers.level1.삼진법뒤집기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        int remainder = 0;
        int quotient = n;
        while (quotient >= 3) {
            list.add(quotient % 3);
            quotient /= 3;
        }
        list.add(quotient);

        int ten = 0;
        for (int i = 0; i < list.size(); i++) {
            ten += Math.pow(3, list.size() - i - 1) * list.get(i);
        }

        return ten;

    }
}
