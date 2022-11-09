package programmers.단어변환;

public class Solution {
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int solution = new Solution().solution(begin, target, words);
        System.out.println(solution);
    }
    public int solution(String begin, String target, String[] words) {

        boolean isPossible = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) {
            return 0;
        }

        boolean[] isVisited = new boolean[words.length];
        getMinValue(0, begin, target, words, isVisited);

        return minValue;
    }

    static void getMinValue(int transValue, String temp, String target, String[] words, boolean[] isVisited) {

        if (temp.equals(target)) {
            minValue = Math.min(minValue, transValue);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && canTrans(temp, words[i])) {
                isVisited[i] = true;
                getMinValue(transValue + 1, words[i], target, words, isVisited);
                isVisited[i] = false;
            }
        }
    }

    static boolean canTrans(String temp, String transWord) {

        int sameCnt = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == transWord.charAt(i)) {
                sameCnt++;
            }
        }

        if (sameCnt >= temp.length() - 1) {
            return true;
        }
        return false;
    }


}
