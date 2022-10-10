package programmers.타겟넘버;

public class Solution2 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int solution = new Solution2().solution(numbers, target);
        System.out.println(solution);
    }
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }

    static void dfs(int depth, int sum, int target, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + numbers[depth], target, numbers);
        dfs(depth + 1, sum - numbers[depth], target, numbers);
    }
}
