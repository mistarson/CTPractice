package programmers.level1.폰켓몬;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));


    }

    static int solution(int[] nums) {

        int able = nums.length / 2;

        int length = Arrays.stream(nums).distinct().toArray().length;

        if (able <= length) {
            return able;
        } else {
            return length;
        }

    }
}
