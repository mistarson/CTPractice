package programmers.level1.없는숫자더하기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        int[] numbers = {5,8,4,0,6,7,9};

        System.out.println(solution(numbers));

    }

    static int solution(int[] numbers) {

        List<Integer> numberList = new ArrayList<>();

        for (int n : numbers) {
            numberList.add(n);
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (!numberList.contains(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
