package programmers.level2.일24나라의숫자;


public class Solution {

    public static void main(String[] args) {
        int n = 10;
        String solution = solution(10);
        System.out.println(solution);
    }
    static String solution(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}
