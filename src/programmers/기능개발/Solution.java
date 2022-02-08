package programmers.기능개발;

import java.util.*;

//TODO 다시풀어보기
public class Solution {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] solution = solution(progresses, speeds);

        System.out.println(Arrays.toString(solution));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[100];
        int day = 0;
        for(int i = 0; i < progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            temp[day]++;
        }
        int cnt = 0;

        for(int n : temp){
            if(n != 0) cnt++;
        }

        int[] answer = new int[cnt];

        cnt = 0;
        for(int n : temp){
            if(n != 0) answer[cnt++] = n;
        }
        return answer;
    }
}
