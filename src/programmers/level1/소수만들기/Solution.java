package programmers.level1.소수만들기;

public class Solution {

    static int cnt = 0;
    static boolean[] visited;
//TODO 이거풀어야함
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        visited = new boolean[nums.length];

        System.out.println(solution(nums));

    }
    static int solution(int[] nums) {

        findPrime(0,0,nums);

        return cnt;
    }

    static void findPrime(int length, int sum, int[] nums) {
        if (length == 3) {
            if (sum == 0 || sum == 1) {
                return;
            }
            for (int i = 2; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    return;
                }
            }
            cnt++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sum += nums[i];
            findPrime(length + 1, sum, nums);
            visited[i] = false;
            sum -= nums[i];
        }
    }
}
