package programmers.마법의엘리베이터;

public class Solution {
    public int solution(int storey) {
        int answer = 0;
        String numbers = String.valueOf(storey);

        int celing = 0;
        for(int i = numbers.length() - 1; i >= 0; i--){
            int number = numbers.charAt(i) - '0' + celing;
            celing = 0;

            if(number > 5){
                answer += 10 - number;
                celing = 1;
                if(i == 0){
                    answer += 1;
                }
            }else if(number == 5){
                if(i != 0){
                    int nextNumber = numbers.charAt(i - 1) - '0' + 1;
                    if(nextNumber > 5){
                        answer += 10 - number;
                        celing = 1;
                    }else{
                        answer += number;
                    }
                }else{
                    answer += number;
                }

            }else{
                answer += number;
            }
        }

        return answer;
    }
}
