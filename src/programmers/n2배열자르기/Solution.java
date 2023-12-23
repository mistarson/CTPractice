package programmers.n2배열자르기;

public class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int answerIdx = 0;

        long currentIdx = left;
        while (currentIdx <= right) {
            int currentRow = (int) (currentIdx / n);
            int extra = (int) (currentIdx % n);
            if (currentRow >= extra) {
                answer[answerIdx++] = (int) (currentRow + 1);
            } else {
                answer[answerIdx++] = extra + 1;
            }
            currentIdx++;
        }

        return answer;
    }
}
