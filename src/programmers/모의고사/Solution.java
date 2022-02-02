package programmers.모의고사;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] answers = {1, 2,3,4,5};

        solution(answers);


    }

    static int[] solution(int[] answers) {
        int[] answer = {};

        int[] supoza1 = {1, 2, 3, 4, 5}; //5
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10

        int supoza1Index = 0;
        int supoza2Index = 0;
        int supoza3Index = 0;

        int supoza1Score = 0;
        int supoza2Score = 0;
        int supoza3Score = 0;


        for (int i = 0; i < answers.length; i++) {

            if (i != 0) {
                if (i % supoza1.length == 0) {
                    supoza1Index += supoza1.length;
                }

                if (i % supoza2.length == 0) {
                    supoza2Index += supoza2.length;
                }

                if (i % supoza3.length == 0) {
                    supoza3Index += supoza3.length;
                }
            }


            if (answers[i] == supoza1[i - supoza1Index]) {
                supoza1Score++;
            }

            if (answers[i] == supoza2[i - supoza2Index]) {
                supoza2Score++;
            }

            if (answers[i] == supoza3[i - supoza3Index]) {
                supoza3Score++;
            }


        }

        int max = Math.max(Math.max(supoza1Score, supoza2Score), supoza3Score);
        List<Integer> list = new ArrayList<>();

        if (max == supoza1Score) {
            list.add(1);
        }
        if (max == supoza2Score) {
            list.add(2);
        }

        if (max == supoza3Score) {
            list.add(3);
        }
        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

}


