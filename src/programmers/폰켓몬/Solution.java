package programmers.폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,3,3,3};
        System.out.println(solution.solution(nums));
    }
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int kind = set.size();
        int pick = nums.length / 2;

        return Math.min(pick, kind);
    }
}
