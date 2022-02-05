//package programmers.카펫;
//
//import java.util.Arrays;
//
//public class TempClass {
//    static int K;
//    static int W, H;
//
//    public static void main(String[] args) {
//
//        int[] solution = solution(5000, 2000000);
//        System.out.println(Arrays.toString(solution));
//
//    }
//
//    static int[] solution(int brown, int yellow) {
//        int[] answer = {};
//        answer = new int[2];
//        K = brown;
//
//        dfs(yellow, 0);
//        answer[0] = W;
//        answer[1] = H;
//
//        return answer;
//    }
//
//    static void dfs(int yellow, int i) {
//        int width = yellow + 2;
//        int brown = width * 2 + (int)Math.pow(2,i)*2;
//        if (brown == K) {
//            W = width;
//            H = (int)Math.pow(2,i) + 2;
//            return;
//        }
//        if(yellow/2 == 0){
//            return;
//        }
//        dfs(yellow/2, i+1);
//    }
//}
