package programmers.성격유형검사하기;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = new int[128];
        int[] surveyScore = {0, 3, 2, 1, 0, 1, 2, 3};

        for (int i = 0; i < survey.length; i++) {
            int selec = choices[i];
            if (selec < 5) {
                char c = survey[i].charAt(0);
                score[c] += surveyScore[selec];
            } else {
                char c = survey[i].charAt(1);
                score[c] += surveyScore[selec];
            }
        }

        answer += score['R'] >= score['T'] ? "R" : "T";
        answer += score['C'] >= score['F'] ? "C" : "F";
        answer += score['J'] >= score['M'] ? "J" : "M";
        answer += score['A'] >= score['N'] ? "A" : "N";

        return answer;
    }
}
